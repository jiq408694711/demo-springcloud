package com.xx.sbc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoDubboServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoDubboServiceApplication.class)
                .web(WebApplicationType.NONE) // NONE为非web工程，一般用于专门提供接口的jar
                .run(args);
    }
}
