package com.xx.sbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring Cloud Gateway features:
 * Built on Spring Framework 5, Project Reactor and Spring Boot 2.0
 * Able to match routes on any request attribute.
 * Predicates and filters are specific to routes.
 * Hystrix Circuit Breaker integration.
 * Spring Cloud DiscoveryClient integration
 * Easy to write Predicates and Filters
 * Request Rate Limiting
 * Path Rewriting
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGatewayApplication.class, args);
    }

}
