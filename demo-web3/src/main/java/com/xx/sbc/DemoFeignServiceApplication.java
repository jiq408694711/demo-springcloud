package com.xx.sbc;

import com.xx.sbc.web2.facade.Web2ServiceFacade;
import com.xx.sbc.web2.utils.FeignClientManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 本项目演示非springboot项目通过原生eureka+ribbon+feign访问springboot项目
 */
@SpringBootApplication
public class DemoFeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFeignServiceApplication.class, args);
    }

    @Bean
    public Web2ServiceFacade buildFeignClient() {
        return FeignClientManager.getApiClient(Web2ServiceFacade.class, "demo-feign-service");
    }
}
