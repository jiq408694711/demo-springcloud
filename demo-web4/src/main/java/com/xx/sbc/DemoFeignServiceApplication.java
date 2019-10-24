package com.xx.sbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 本项目演示spring-cloud下eureka+ribbon+feign访问springcloud项目
 */
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class DemoFeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFeignServiceApplication.class, args);
    }

}
