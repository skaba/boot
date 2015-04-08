package com.serkan.spring.boot;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.serkan.spring.boot.operation.math.impl.MathOperationServiceRegistry;
import com.serkan.spring.boot.operation.text.impl.TextOperationServiceRegistry;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApplication.class)
@WebAppConfiguration
public class BootApplicationTests {

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
