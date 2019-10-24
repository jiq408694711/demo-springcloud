package com.xx.sbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableHystrix
public class DemoWeb2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoWeb2Application.class, args);
    }

}
