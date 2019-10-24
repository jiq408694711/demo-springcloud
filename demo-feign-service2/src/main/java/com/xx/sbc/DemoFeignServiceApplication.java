package com.xx.sbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 本项目为普通springcloud项目
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoFeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFeignServiceApplication.class, args);
    }

}
