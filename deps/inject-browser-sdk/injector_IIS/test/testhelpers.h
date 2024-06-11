#pragma once
#include "framework.h"
#include "ruminjector.h"

// Fixture which gives the tests access to private members of CRUMInjectorFactory
class TestCRUMInjectorFactory : public ::testing::Test
{
    CRUMInjectorFactory* injectorFactory;
 
protected:
    std::shared_ptr<MockLogger> mockLogger;

    virtual void SetUp()
    {
        mockLogger = std::make_shared<MockLogger>(L"MockLogger");
        injectorFactory = new CRUMInjectorFactory(mockLogger);

        // ignore debug log calls
        EXPECT_CALL(*mockLogger, WriteEventViewerDebugLog).Times(::testing::AnyNumber());
    }

    virtual void TearDown()
    {
        injectorFactory->Terminate();
    }

    HRESULT ReadConfigs(std::string configDirectory) {
        return injectorFactory->ReadConfigs(configDirectory);
    }

    std::unordered_map<std::string, Snippet*> GetSnippetsBySite() {
        return injectorFactory->m_snippetsBySite;
    }
};

// Fixture which gives the tests access to private members of CRUMInjector
class TestCRUMInjector : public ::testing::Test
{
    CRUMInjector* injector;
    std::shared_ptr<MockLogger> mockLogger;

protected:
    virtual void SetUp()
    {
        const std::unordered_map<std::string, Snippet*> snippetsBySite;
        mockLogger = std::make_shared<MockLogger>(L"MockLogger");

        injector = new CRUMInjector(mockLogger, snippetsBySite);

        // ignore debug log calls
        EXPECT_CALL(*mockLogger, WriteEventViewerDebugLog).Times(::testing::AnyNumber());
    }

    virtual void TearDown()
    {
        injector->Dispose();
    }

    bool ShouldAttemptInjection(IHttpResponse* pHttpResponse) {
        return injector->ShouldAttemptInjection(pHttpResponse);
    };

};