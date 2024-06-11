#include "ruminjector.h"

static const std::string INJECTION_PENDING_HEADER = "x-datadog-rum-injection-pending";
static const std::string INJECTION_HEADER = "x-datadog-rum-injected";
static const std::string HEADER_VALUE = "1";

static const std::string REGISTRY_PATH = "Software\\DataDog\\Datadog RUM";
static const std::string REGISTRY_KEY = "ConfigRoot";
static const std::string CONF_FILE_NAME = "rum-config.json";

/*
 * CRUMInjector
 */

CRUMInjector::CRUMInjector(std::shared_ptr<Logger> logger, const std::unordered_map<std::string, Snippet*>& snippetsBySite)
    : m_logger(logger), m_snippetsBySite(snippetsBySite)
{}

REQUEST_NOTIFICATION_STATUS
CRUMInjector::OnBeginRequest(
    IN IHttpContext* pHttpContext,
    IN IHttpEventProvider* pProvider
)
{
    IHttpRequest* pHttpRequest = pHttpContext->GetRequest();
    if (pHttpRequest == NULL)
    {
        m_logger->WriteEventViewerDebugLog("HTTP request was null");
        return RQ_NOTIFICATION_CONTINUE;
    }

    HRESULT result = pHttpRequest->SetHeader(INJECTION_PENDING_HEADER.c_str(), HEADER_VALUE.c_str(), HEADER_VALUE.length(), TRUE);
    if (result != S_OK)
    {
        pProvider->SetErrorStatus(result);
        m_logger->WriteEventViewerDebugLog("Error setting request header: " + std::system_category().message(result));
    }

    return RQ_NOTIFICATION_CONTINUE;
}

REQUEST_NOTIFICATION_STATUS
CRUMInjector::OnSendResponse(
    IN IHttpContext* pHttpContext,
    IN ISendResponseProvider* pProvider
)
{
    UNREFERENCED_PARAMETER(pProvider);
    
    IHttpResponse* pHttpResponse = pHttpContext->GetResponse();
    if (pHttpResponse == NULL)
    {
        m_logger->WriteEventViewerDebugLog("Skipping RUM injection: HTTP response was null");
        return RQ_NOTIFICATION_CONTINUE;
    }

    if (!ShouldAttemptInjection(pHttpResponse))
    {
        return RQ_NOTIFICATION_CONTINUE;
    }

    std::string siteName = GetRequestSiteName(pHttpContext);
    if (siteName.empty())
    {
        m_logger->WriteEventViewerDebugLog("Skipping RUM injection: failed to read site name of http response");
        return RQ_NOTIFICATION_CONTINUE;
    }

    if (!m_snippetsBySite.contains(siteName))
    {
        m_logger->WriteEventViewerDebugLog("Skipping RUM injection: site '" + siteName + "' is not configured");
        return RQ_NOTIFICATION_CONTINUE;
    }

    m_logger->WriteEventViewerDebugLog("Attempting to perform RUM injection into response from site '" + siteName + "'");
    return PerformInjection(pHttpResponse, m_snippetsBySite.at(siteName));
}

std::string
CRUMInjector::GetRequestSiteName(IHttpContext* pHttpContext)
{
    IHttpSite* pHttpSite = pHttpContext->GetSite();
    if (pHttpSite == NULL)
    {
        return "";
    }

    PCWSTR pwszSiteName = pHttpSite->GetSiteName();
    if (pwszSiteName == NULL)
    {
        return "";
    }

    size_t siteNameSize = wcslen(pwszSiteName) + 1;
    char* siteName = (char*)pHttpContext->AllocateRequestMemory((DWORD)siteNameSize);
    if (siteName == NULL)
    {
        return "";
    }

    size_t output = 0;
    wcstombs_s(&output, siteName, siteNameSize, pwszSiteName, wcslen(pwszSiteName));
    return std::string(siteName);
}

bool
CRUMInjector::ShouldAttemptInjection(IHttpResponse* pHttpResponse)
{
    // First, we must validate the the content type is 'text/html'
    // Note that the value of the Content-Type header is case insensitive, and it may or may not be be followed by semicolon-delimited parameters
    //   ie Text/HTML;Charset="utf-8"
    // see https://www.rfc-editor.org/rfc/rfc9110#name-content-type

    USHORT contentTypeHeaderLen;
    PCSTR pContentTypeHeader = pHttpResponse->GetHeader("Content-Type", &contentTypeHeaderLen);
    if (contentTypeHeaderLen == 0 || pContentTypeHeader == NULL)
    {
        m_logger->WriteEventViewerDebugLog("Skipping RUM injection: 'Content-Type' header was not found");
        return false;
    }

    if (_strnicmp(pContentTypeHeader, "text/html", 9) != 0) {
        m_logger->WriteEventViewerDebugLog("Skipping RUM injection: content type is not text/html ");
        return false;
    }

    // We must also validate that another injector in this environment hasn't previously attempted injection into this response
    USHORT injectionHeaderLen;
    pHttpResponse->GetHeader(INJECTION_HEADER.c_str(), &injectionHeaderLen);
    if (injectionHeaderLen > 0)
    {
        m_logger->WriteEventViewerDebugLog("Skipping RUM injection: injection has already been attempted on this response");
        return false;
    }

    return true;
}

REQUEST_NOTIFICATION_STATUS
CRUMInjector::PerformInjection(
    IHttpResponse* pHttpResponse,
    Snippet* snippet
)
{
    HRESULT result = pHttpResponse->SetHeader(INJECTION_HEADER.c_str(), HEADER_VALUE.c_str(), HEADER_VALUE.length(), TRUE);
    if (result != S_OK)
    {
        m_logger->WriteEventViewerDebugLog("Error setting injection header: " + std::system_category().message(result));
        return RQ_NOTIFICATION_CONTINUE;
    }

    HTTP_RESPONSE* pResponseStruct = pHttpResponse->GetRawHttpResponse();
    if (pResponseStruct == NULL)
    {
        m_logger->WriteEventViewerDebugLog("Raw HTTP response was null");
        return RQ_NOTIFICATION_CONTINUE;
    }

    if (pResponseStruct->EntityChunkCount == 0)
    {
        m_logger->WriteEventViewerDebugLog("Raw HTTP response does not contain any data");
        return RQ_NOTIFICATION_CONTINUE;
    }

    Injector* injector = injector_create(snippet);
    if (injector == NULL)
    {
        m_logger->WriteEventViewerDebugLog("Error creating injector");
        return RQ_NOTIFICATION_CONTINUE;
    }

    // Pre-allocate all the memory we'll need to hold the new response
    int newResponseSize = snippet->length;
    for (int i = 0; i < pResponseStruct->EntityChunkCount; i++) {
        if (pResponseStruct->pEntityChunks[i].DataChunkType != HttpDataChunkFromMemory)
        {
            m_logger->WriteEventViewerDebugLog("Skipping response which is not in memory: response type = " + std::to_string(pResponseStruct->pEntityChunks[i].DataChunkType));
            injector_cleanup(injector);
            return RQ_NOTIFICATION_CONTINUE;
        }

        newResponseSize += pResponseStruct->pEntityChunks[i].FromMemory.BufferLength;
    }
    std::string newResponse;
    newResponse.reserve(newResponseSize);

    // Write the existing data chunks to the injector, and then write the resulting byte slices into our new response string
    for (int i = 0; i < pResponseStruct->EntityChunkCount; i++) {
        const char* responseBuf = (const char*)pResponseStruct->pEntityChunks[i].FromMemory.pBuffer;
        ULONG responseBufLength = pResponseStruct->pEntityChunks[i].FromMemory.BufferLength;

        InjectorResult injectorResult = injector_write(injector, (uint8_t*)responseBuf, responseBufLength);
        WriteByteSlicesIntoResponse(injectorResult.slices, injectorResult.slices_length, newResponse);
    }
    InjectorResult injectorResult = injector_end(injector);
    WriteByteSlicesIntoResponse(injectorResult.slices, injectorResult.slices_length, newResponse);
    
    m_logger->WriteEventViewerDebugLog("Writing new response");
    result = WriteResponseMessage(pHttpResponse, pResponseStruct, newResponse.c_str(), newResponse.size());
    if (FAILED(result))
    {
        m_logger->WriteEventViewerDebugLog("Error while overwriting response message: " + std::system_category().message(result));
        pHttpResponse->SetStatus(500, "Server Error", 0, result);
    }

    BOOL fAsync = FALSE;
    BOOL fMoreData = FALSE;
    DWORD bytesSent;
    result = pHttpResponse->Flush(fAsync, fMoreData, &bytesSent);
    if (FAILED(result))
    {
        m_logger->WriteEventViewerDebugLog("Error while flushing response: " + std::system_category().message(result));
    }

    injector_cleanup(injector);
    return RQ_NOTIFICATION_FINISH_REQUEST;
}

void
CRUMInjector::WriteByteSlicesIntoResponse(
    const BytesSlice* slices,
    uint32_t numSlices,
    std::string& response
)
{
    /*
    A note on memory ownership:

    The byte slices passed to this function may contain pointers to internal buffers allocated by the injectbrowsersdk library. These buffers become invalidated
    upon the next call to either injector_write or injector_end. As a result, it should be assumed that any memory pointed to by these byte slices is only valid
    until the end of this function. However, since we are copying the contents of these slices into our new response string, this is perfectly safe.
    */

    for (uint32_t i = 0; i < numSlices; i++) {
        response.append((char*)slices[i].start, slices[i].length);
    }
}

HRESULT
CRUMInjector::WriteResponseMessage(
    IHttpResponse* pHttpResponse,
    HTTP_RESPONSE* pResponseStruct,
    PCSTR pBuffer,
    size_t pBufferLen
)
{
    if (pBufferLen > ULONG_MAX) {
        m_logger->WriteEventViewerErrorLog("Injection failed: response is too large");
        return HRESULT_FROM_WIN32(ERROR_INTERNAL_ERROR);
    }

    // We need to clear the response body, but doing so clears the headers & status information as well. So,
    // we'll need to copy that data & write it in after clearing.
    HTTP_RESPONSE responseStructCopy;
    memcpy(&responseStructCopy, pResponseStruct, sizeof(HTTP_RESPONSE));

    pHttpResponse->Clear();

    pHttpResponse->SetStatus(responseStructCopy.StatusCode, responseStructCopy.pReason);
    CopyResponseHeaders(&responseStructCopy, pHttpResponse);

    HTTP_RESPONSE* newResponse = pHttpResponse->GetRawHttpResponse();
    if (newResponse != NULL) {
        newResponse->Flags = responseStructCopy.Flags;
        newResponse->Version = responseStructCopy.Version;
    }

    HTTP_DATA_CHUNK dataChunk;
    dataChunk.DataChunkType = HttpDataChunkFromMemory;
    dataChunk.FromMemory.pBuffer = (PVOID)pBuffer;
    dataChunk.FromMemory.BufferLength = pBufferLen;

    DWORD nChunks = 1;
    BOOL fAsync = FALSE;
    BOOL fMoreData = FALSE;
    DWORD bytesSent;
    HRESULT result = pHttpResponse->WriteEntityChunks(&dataChunk, nChunks, fAsync, fMoreData, &bytesSent);
    if (FAILED(result))
    {
        return result;
    }
    return S_OK;
}

void
CRUMInjector::CopyResponseHeaders(HTTP_RESPONSE* source, IHttpResponse* dest)
{
    for (int i = 0; i < source->Headers.UnknownHeaderCount; i++) {
        dest->SetHeader(
            source->Headers.pUnknownHeaders[i].pName,
            source->Headers.pUnknownHeaders[i].pRawValue,
            source->Headers.pUnknownHeaders[i].RawValueLength,
            TRUE
        );
    }

    for (int i = 0; i < HttpHeaderResponseMaximum; i++) {
        if (source->Headers.KnownHeaders[i].RawValueLength != 0)
        {
            dest->SetHeader(
                (HTTP_HEADER_ID) i,
                source->Headers.KnownHeaders[i].pRawValue,
                source->Headers.KnownHeaders[i].RawValueLength,
                TRUE
            );
        }
    }
}

/*
 * CRUMInjectorFactory
 */

CRUMInjectorFactory::CRUMInjectorFactory(std::shared_ptr<Logger> logger) : m_logger(logger)
{}

HRESULT CRUMInjectorFactory::ReadConfigs(std::string configDirectory)
{
    const std::filesystem::path rootDir{ configDirectory };

    for (auto const& dir_entry : std::filesystem::directory_iterator{ rootDir })
    {
        if (!dir_entry.is_directory())
        {
            continue;
        }

        m_logger->WriteEventViewerDebugLog("Found configuration subdirectory " + dir_entry.path().string());

        std::filesystem::path configFilePath{ dir_entry.path() / CONF_FILE_NAME };

        std::ifstream configFile{ configFilePath };
        if (!configFile) {
            m_logger->WriteEventViewerDebugLog("Failed to find " + configFilePath.string());
            continue;
        }

        json config;
        try
        {
            config = json::parse(configFile);
        }
        catch (const json::parse_error& e)
        {
            m_logger->WriteEventViewerErrorLog("Failed to parse JSON in " + configFilePath.string() + ": "+ std::string(e.what()));
            continue;
        }

        Snippet* snippet = snippet_create_from_json(config.dump().c_str());
        if (snippet == NULL)
        {
            m_logger->WriteEventViewerErrorLog("Error generating snippet from JSON at " + configFilePath.string());
            continue;
        }
        if (snippet->error_code != 0)
        {
            m_logger->WriteEventViewerErrorLog("Error generating snippet from JSON at " + configFilePath.string() + ": " + std::string(snippet->error_message));
            snippet_cleanup(snippet);
            continue;
        }

        std::string siteName = dir_entry.path().filename().string();

        // GetSiteName returns an all-uppercase string, so we need to convert the given site names to match
        std::transform(siteName.begin(), siteName.end(), siteName.begin(), toupper);

        if (m_snippetsBySite.contains(siteName)) {
            m_logger->WriteEventViewerDebugLog("Found multiple configurations for site " + siteName);
            // in this case, keep whichever configuration we saw first
            snippet_cleanup(snippet);
            continue;
        }

        m_snippetsBySite[siteName] = snippet;
    }

    if (m_snippetsBySite.empty())
    {
        return HRESULT_FROM_WIN32(ERROR_INTERNAL_ERROR);
    }

    return S_OK;
}

HRESULT
CRUMInjectorFactory::GetHttpModule(
    OUT CHttpModule** ppModule,
    IN IModuleAllocator* pAllocator
)
{
    UNREFERENCED_PARAMETER(pAllocator);

    CRUMInjector* pModule = new CRUMInjector(m_logger, m_snippetsBySite);
    if (!pModule)
    {
        m_logger->WriteEventViewerDebugLog("Failed to create http module: failed to allocate CRUMInjector");
        return HRESULT_FROM_WIN32(ERROR_NOT_ENOUGH_MEMORY);
    }

    *ppModule = pModule;
    pModule = NULL;
    return S_OK;
}

void
CRUMInjectorFactory::Terminate()
{
    for (auto mapEntry : m_snippetsBySite) {
        snippet_cleanup(mapEntry.second);
    }

    delete this;
}

/*
 * RegisterModule
 */

HRESULT
__stdcall
RegisterModule(
    DWORD dwServerVersion,
    IHttpModuleRegistrationInfo* pModuleInfo,
    IHttpServer* pGlobalInfo
)
{
    UNREFERENCED_PARAMETER(dwServerVersion);
    UNREFERENCED_PARAMETER(pGlobalInfo);

    auto logger = std::make_shared<Logger>(L"DDIISInjectorModule");
    logger->WriteEventViewerDebugLog("Registering Datadog RUM Injector IIS Module");

    PCWSTR appPoolNameW = pGlobalInfo->GetAppPoolName();
    std::string appPoolName = "(app pool name unknown)";
    if (appPoolNameW != NULL)
    {
        std::wstring wideStr(appPoolNameW);
        appPoolName = std::string(wideStr.begin(), wideStr.end());
        // Note that appPoolName is only used to add context to error logs, so it's not a fatal error if we can't read it
    }

    if (pModuleInfo == NULL)
    {
        /*
        If we return an error from the RegisterModule function, IIS will retry registering this module, but if it keeps failing then eventually the
        application pool which is calling RegisterModule will come to a complete stop.
        We don't want to cause any downtime on our customers servers, so even in the case of a fatal error, we will simply write an error to the 
        event log and return S_OK.
        */
        logger->WriteEventViewerErrorLog("Failed to register RUM Injector module in application pool " + appPoolName + ": pModuleInfo was null");
        return S_OK;
    }
    
    std::string configDirectory = getRumInjectorConfigDirectory();
    if(configDirectory.empty()){
        logger->WriteEventViewerErrorLog("Failed to register RUM Injector module in application pool " + appPoolName + ": failed to read location of configuration directory");
        return S_OK;
    }
    logger->WriteEventViewerDebugLog("Read config directory as " + configDirectory);

    CRUMInjectorFactory* factory = new CRUMInjectorFactory(logger);
    if (factory == NULL)
    {
        logger->WriteEventViewerErrorLog("Failed to register RUM Injector module in application pool " + appPoolName + ": failed to allocate RUM Injector Factory");
        return S_OK;
    }

    HRESULT result = factory->ReadConfigs(configDirectory);
    if (result != S_OK)
    {
        logger->WriteEventViewerErrorLog("Failed to register RUM Injector module in application pool " + appPoolName + ": no valid configuration files were found");
        factory->Terminate();
        return S_OK;
    }

    // Register our module to be notified when a SendResponse or BeginRequest event occurs
    result = pModuleInfo->SetRequestNotifications(
        factory,
        RQ_SEND_RESPONSE | RQ_BEGIN_REQUEST,
        0
    );
    if (result != S_OK)
    {
        logger->WriteEventViewerErrorLog("Failed to register RUM Injector module in application pool " + appPoolName + ": SetRequestNotifications returned " + std::system_category().message(result));
        factory->Terminate();
    }
    return S_OK;
}

std::string getRumInjectorConfigDirectory()
{
#ifdef TESTING
    return std::string(TEST_DIR) + "/test_config_dir";
#endif

    char buf[MAX_PATH] = { 0 };
    DWORD len = MAX_PATH;
    DWORD dwType = 0;
    // try to read from registry
    LSTATUS status = RegGetValueA(HKEY_LOCAL_MACHINE,
        REGISTRY_PATH.c_str(),
        REGISTRY_KEY.c_str(),
        RRF_RT_REG_SZ,
        &dwType,
        buf,
        &len);
    if (ERROR_SUCCESS == status) {
        return buf;
    }

    return "";
}