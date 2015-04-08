package com.serkan.spring.boot;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.serkan.spring.boot.operation.Operation;
import com.serkan.spring.boot.operation.impl.OperationServiceRegistry;
import com.serkan.spring.boot.operation.impl.ReduceOperation;
import com.serkan.spring.boot.operator.math.impl.Add;
import com.serkan.spring.boot.operator.math.impl.Multiply;
import com.serkan.spring.boot.operator.text.impl.Concat;

@SpringBootApplication
public class BootApplication {

    @Bean
    public Operation<BigDecimal> addOperation(final OperationServiceRegistry<BigDecimal> registry, final Add add) {
        return new ReduceOperation<BigDecimal>("add", add, registry);
    }

    @Bean
    public Operation<BigDecimal> multiplyOperation(final OperationServiceRegistry<BigDecimal> registry, final Multiply multiply) {
        return new ReduceOperation<BigDecimal>("multiply", multiply, registry);
    }

    @Bean
    public Operation<String> concatOperation(final OperationServiceRegistry<String> registry, final Concat concat) {
        return new ReduceOperation<String>("concat", concat, registry);
    }

    public static void main(final String[] args) {
        SpringApplication.run(BootApplication.class, args);

    }
}
