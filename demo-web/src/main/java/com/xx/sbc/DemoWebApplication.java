package com.xx.sbc;

import com.xx.sbc.web2.facade.Web2ServiceFacade;
import com.xx.sbc.web2.utils.FeignClientManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableHystrix
public class DemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebApplication.class, args);
    }

    @Bean
    public Web2ServiceFacade buildFeignClient() {
        return FeignClientManager.getApiClient(Web2ServiceFacade.class, "demo-feign-service");
    }
}
