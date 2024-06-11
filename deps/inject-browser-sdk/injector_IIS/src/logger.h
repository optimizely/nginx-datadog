#pragma once
#include "framework.h"

// Note that Logger's functions are virtual so that we can mock it for testing purposes
class Logger
{
    HANDLE m_eventLog;

public:
    Logger(LPCWSTR name)
    {
        m_eventLog = RegisterEventSource(NULL, name);
    }

    virtual ~Logger()
    {
        if (m_eventLog != NULL)
        {
            DeregisterEventSource(m_eventLog);
            m_eventLog = NULL;
        }
    }

    virtual BOOL WriteEventViewerErrorLog(std::string text) const
    {
        if (m_eventLog != NULL)
        {
            std::wstring wtext = std::wstring(text.begin(), text.end());
            LPCWSTR szNotification = wtext.c_str();

            return ReportEvent(
                m_eventLog,             // hEventLog
                EVENTLOG_ERROR_TYPE,    // wType
                0,                      // wCategory
                0,                      // dwEventID
                NULL,                   // lpUserSid
                1,                      // wNumStrings
                0,                      // dwDataSize
                &szNotification,        // lpStrings
                NULL);                  // lpRawData
    }
        return FALSE;
    }

    virtual BOOL WriteEventViewerDebugLog(std::string text) const
    {
#if _DEBUG
        if (m_eventLog != NULL)
        {
            std::wstring wtext = std::wstring(text.begin(), text.end());
            LPCWSTR szNotification = wtext.c_str();

            return ReportEvent(
                m_eventLog,
                EVENTLOG_INFORMATION_TYPE, 0, 0,
                NULL, 1, 0, &szNotification, NULL);
        }
        return FALSE;
#else 
        // Debug logs should not be compiled into non-debug builds
        return TRUE;
#endif
    }
};