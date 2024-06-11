#include "gtest/gtest.h"
#include "ruminjector.h"
#include "mocks.h"
#include "testhelpers.h"

using ::testing::DoAll;
using ::testing::Return;
using ::testing::SaveArg;
using ::testing::Invoke;
using ::testing::Eq;
using ::testing::StrEq;
using ::testing::An;
using ::testing::HasSubstr;
using ::testing::Matcher;
using::testing::_;

static const std::string REGISTRY_PATH = "Software\\DataDog\\Datadog RUM";
static const std::string REGISTRY_KEY = "ConfigRoot";

// Set StrictMock so that any unexpected calls to mocked objects results in test failure
using ::testing::StrictMock;

TEST(TestRegisterModule, TestRegistersForBeginRequestAndSendResponseNotifications) {
    MockModule module;
    MockServer server;

    EXPECT_CALL(server, GetAppPoolName).Times(1);
    EXPECT_CALL(module, SetRequestNotifications(_, RQ_SEND_RESPONSE | RQ_BEGIN_REQUEST, _)).Times(1);

    auto result = RegisterModule(0, &module, &server);

    EXPECT_EQ(result, S_OK);
}

TEST(TestRegisterModule, TestRegistersValidHTTPModuleFactory) {
    MockModule module;
    MockServer server;

    IHttpModuleFactory* resultFactory = NULL;
    ON_CALL(module, SetRequestNotifications).WillByDefault(DoAll(
        SaveArg<0>(&resultFactory),
        Return(S_OK)
    ));

    EXPECT_CALL(module, SetRequestNotifications).Times(1);

    auto result = RegisterModule(0, &module, &server);

    EXPECT_EQ(result, S_OK);
    ASSERT_NE(resultFactory, nullptr);

    CHttpModule* resultFactoryOutput = NULL;
    result = resultFactory->GetHttpModule(&resultFactoryOutput, NULL);

    EXPECT_EQ(result, S_OK);
    EXPECT_NE(resultFactoryOutput, nullptr);

    resultFactory->Terminate();
}

TEST_F(TestCRUMInjectorFactory, TestReadConfigs) {
    auto result = ReadConfigs(std::string(TEST_DIR) + "\\test_config_dir");
    ASSERT_EQ(result, S_OK);

    auto snippetsBySite = GetSnippetsBySite();
    ASSERT_EQ(snippetsBySite.size(), 1);

    Snippet* snippet = snippetsBySite["SITE_WITH_VALID_CONFIG"];
    ASSERT_NE(snippet, nullptr);
}

TEST_F(TestCRUMInjectorFactory, ReadConfigs_CatchesInvalidJSON) {
    auto result = ReadConfigs(std::string(TEST_DIR) + "\\test_config_dir_bad_json");
    ASSERT_NE(result, S_OK);

    auto snippetsBySite = GetSnippetsBySite();
    ASSERT_EQ(snippetsBySite.size(), 0);
}

TEST_F(TestCRUMInjectorFactory, ReadConfigs_CatchesInvalidConfig) {
    auto result = ReadConfigs(std::string(TEST_DIR) + "\\test_config_dir_invalid_config");
    ASSERT_NE(result, S_OK);

    auto snippetsBySite = GetSnippetsBySite();
    ASSERT_EQ(snippetsBySite.size(), 0);
}

TEST_F(TestCRUMInjector, ShouldAttemptInjection_ReturnsFalseForMissingContentTypeHeader) {
    MockHttpResponse httpResponse;

    const char* contentTypeHeader = "Content-Type";
    const char* contentTypeHeaderValue = "";

    EXPECT_CALL(httpResponse, GetHeader(Matcher<PCSTR>(StrEq(contentTypeHeader)), _)).WillOnce(DoAll(
        Invoke([contentTypeHeaderValue](_In_ PCSTR headerName, _Out_ USHORT* headerValueLen)
            {
                *headerValueLen = strlen(contentTypeHeaderValue);
            }),
        Return(contentTypeHeaderValue))
    );

    bool result = ShouldAttemptInjection(&httpResponse);
    EXPECT_EQ(result, false);
}

TEST_F(TestCRUMInjector, ShouldAttemptInjection_ReturnsFalseForIncorrectContentTypeHeader) {
    MockHttpResponse httpResponse;

    const char* contentTypeHeader = "Content-Type";
    const char* contentTypeHeaderValue = "foo/bar";

    EXPECT_CALL(httpResponse, GetHeader(Matcher<PCSTR>(StrEq(contentTypeHeader)), _)).WillOnce(DoAll(
        Invoke([contentTypeHeaderValue](_In_ PCSTR headerName, _Out_ USHORT* headerValueLen)
            {
                *headerValueLen = strlen(contentTypeHeaderValue);
            }),
        Return(contentTypeHeaderValue))
    );

    bool result = ShouldAttemptInjection(&httpResponse);
    EXPECT_EQ(result, false);
}

TEST_F(TestCRUMInjector, ShouldAttemptInjection_ReturnsFalseWhenCustomHeaderPresent) {
    MockHttpResponse httpResponse;

    const char* contentTypeHeader = "Content-Type";
    const char* contentTypeHeaderValue = "text/html";

    const char* customHeader = "x-datadog-rum-injected";
    const char* customHeaderValue = "1";

    EXPECT_CALL(httpResponse, GetHeader(Matcher<PCSTR>(StrEq(contentTypeHeader)), _)).WillOnce(DoAll(
        Invoke([contentTypeHeaderValue](_In_ PCSTR headerName, _Out_ USHORT* headerValueLen)
            {
                *headerValueLen = strlen(contentTypeHeaderValue);
            }),
        Return(contentTypeHeaderValue))
    );

    EXPECT_CALL(httpResponse, GetHeader(Matcher<PCSTR>(StrEq(customHeader)), _)).WillOnce(DoAll(
        Invoke([customHeaderValue](_In_ PCSTR headerName, _Out_ USHORT* headerValueLen)
            {
                *headerValueLen = strlen(customHeaderValue);
            }),
        Return(customHeaderValue))
    );

    bool result = ShouldAttemptInjection(&httpResponse);
    EXPECT_EQ(result, false);
}

TEST_F(TestCRUMInjector, ShouldAttemptInjection_ReturnsTrueForValidHeaders) {
    MockHttpResponse httpResponse;

    const char* contentTypeHeader = "Content-Type";
    const char* contentTypeHeaderValue = "Text/HTML; Charset=\"utf - 8\"";

    const char* customHeader = "x-datadog-rum-injected";
    const char* customHeaderValue = "";

    EXPECT_CALL(httpResponse, GetHeader(Matcher<PCSTR>(StrEq(contentTypeHeader)), _)).WillOnce(DoAll(
        Invoke([contentTypeHeaderValue](_In_ PCSTR headerName, _Out_ USHORT* headerValueLen)
            {
                *headerValueLen = strlen(contentTypeHeaderValue);
            }),
        Return(contentTypeHeaderValue))
    );

    EXPECT_CALL(httpResponse, GetHeader(Matcher<PCSTR>(StrEq(customHeader)), _)).WillOnce(DoAll(
        Invoke([customHeaderValue](_In_ PCSTR headerName, _Out_ USHORT* headerValueLen)
            {
                *headerValueLen = strlen(customHeaderValue);
            }),
        Return(customHeaderValue))
    );

    bool result = ShouldAttemptInjection(&httpResponse);
    EXPECT_EQ(result, true);
}