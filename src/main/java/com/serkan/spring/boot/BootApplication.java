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

    /**
     * Creates Add operation
     * 
     * @param registry Operation registry
     * @param add Add operator
     * @return Add operation
     */
    @Bean
    public Operation<BigDecimal> addOperation(final OperationServiceRegistry<BigDecimal> registry, final Add add) {
        return new ReduceOperation<BigDecimal>("add", add, registry);
    }

    /**
     * Creates Multiply operation
     * 
     * @param registry Operation registry
     * @param multiply Multiply operator
     * @return Multiply operation
     */
    @Bean
    public Operation<BigDecimal> multiplyOperation(final OperationServiceRegistry<BigDecimal> registry, final Multiply multiply) {
        return new ReduceOperation<BigDecimal>("multiply", multiply, registry);
    }

    /**
     * Creates Concat operation
     * 
     * @param registry Operation registry
     * @param concat Concat operator
     * @return Concat operation
     */
    @Bean
    public Operation<String> concatOperation(final OperationServiceRegistry<String> registry, final Concat concat) {
        return new ReduceOperation<String>("concat", concat, registry);
    }

    /**
     * Runs the application
     * 
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
