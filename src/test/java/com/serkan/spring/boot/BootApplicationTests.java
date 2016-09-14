package com.serkan.spring.boot;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import com.serkan.spring.boot.operation.math.impl.MathOperationServiceRegistry;
import com.serkan.spring.boot.operation.text.impl.TextOperationServiceRegistry;

@WebAppConfiguration
public class BootApplicationTests extends AbstractITTest {

    @Autowired
    private MathOperationServiceRegistry mathOperationRegistry;

    @Autowired
    private TextOperationServiceRegistry textOperationRegistry;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testOperations() {
        assertNotNull(mathOperationRegistry.getElement("add"));
        assertNotNull(mathOperationRegistry.getElement("multiply"));
        assertNotNull(mathOperationRegistry.getElement("divide"));
        assertNotNull(mathOperationRegistry.getElement("subtract"));
        assertNotNull(textOperationRegistry.getElement("concat"));
    }

}
