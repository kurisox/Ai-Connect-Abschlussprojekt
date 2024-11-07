package com.bs.ai_connect.ai_connector_tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.ai_connector.AiConenctor;



@SpringBootTest
public class AiConnectorTests {

    @Test
    public void testGetInstance() {
        assertNotNull(AiConenctor.getInstance());
    }

    @Test
    public void testGetInstance_Singleton() {
        assertSame(AiConenctor.getInstance(), AiConenctor.getInstance());
    }

    @Test
    public void testHttpClientInitialization() {
        assertNotNull(AiConenctor.getInstance().getHTTP_CLIENT());
    }

}
