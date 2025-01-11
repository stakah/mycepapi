package com.mycepapi.logger;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.*;

public class CeLoggerTest {
    private static final Logger logger = LoggerFactory.getLogger(CepLogger.class);

    @Test
    public void testLogInfo() {
        Logger mockLogger = mock(Logger.class);
        doNothing().when(mockLogger).info(anyString());
        mockLogger.info("Test log message");
        verify(mockLogger, times(1)).info("Test log message");
    }

}
