#pragma once
#include <string>
#include <unordered_map>
#include <typeindex>
#include <fstream>
#include <filesystem>
#include "framework.h"
#include "logger.h"
#include "json.h"
#include "injectbrowsersdk.h"

using json = nlohmann::json;

std::string getRumInjectorConfigDirectory();

class CRUMInjector : public CHttpModule
{
#ifdef TESTING
    friend class TestCRUMInjector;
#endif

    std::shared_ptr<Logger> m_logger;
    const std::unordered_map<std::string, Snippet*>& m_snippetsBySite;

public:
    CRUMInjector(std::shared_ptr<Logger> logger, const std::unordered_map<std::string, Snippet*>& snippetsBySite);
    CRUMInjector(std::shared_ptr<Logger> logger, const std::unordered_map<std::string, Snippet*>&&) = delete; // ensure we don't accept a reference to a temporary object

    REQUEST_NOTIFICATION_STATUS OnBeginRequest(
        IN IHttpContext* pHttpContext,
        IN IHttpEventProvider* pProvider
    );

    REQUEST_NOTIFICATION_STATUS OnSendResponse(
        IN IHttpContext* pHttpContext,
        IN ISendResponseProvider* pProvider
    );

private:
    std::string GetRequestSiteName(IHttpContext* pHttpContext);

    bool ShouldAttemptInjection(
        IHttpResponse* pHttpResponse
    );

    REQUEST_NOTIFICATION_STATUS PerformInjection(
        IHttpResponse* pHttpResponse,
        Snippet* snippet
    );

    void WriteByteSlicesIntoResponse(
        const BytesSlice* slices,
        uint32_t numSlices,
        std::string& response
    );

    HRESULT WriteResponseMessage(
        IHttpResponse* pHttpResponse,
        HTTP_RESPONSE* pResponseStruct,
        PCSTR pBuffer,
        size_t pBufferLen
    );

    void CopyResponseHeaders(
        HTTP_RESPONSE* source,
        IHttpResponse* dest
    );
};

class CRUMInjectorFactory : public IHttpModuleFactory
{
#ifdef TESTING
    friend class TestCRUMInjectorFactory;
#endif

    std::shared_ptr<Logger> m_logger;
    std::unordered_map<std::string, Snippet*> m_snippetsBySite;

public:
    CRUMInjectorFactory(std::shared_ptr<Logger> logger);

    HRESULT ReadConfigs(std::string configPath);
    
    HRESULT GetHttpModule(
        OUT CHttpModule** ppModule,
        IN IModuleAllocator* pAllocator
    );

    void Terminate();
};

HRESULT
__stdcall
RegisterModule(
    DWORD dwServerVersion,
    IHttpModuleRegistrationInfo* pModuleInfo,
    IHttpServer* pGlobalInfo
);