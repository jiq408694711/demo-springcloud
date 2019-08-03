package com.xx.sbc.web1.facade;

import com.xx.sbc.web1.response.HelloResponse;
import org.springframework.stereotype.Component;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@Component
public class DemoServiceFacadeFallback implements DemoServiceFacade {

    @Override
    public HelloResponse get(Long id) {
        HelloResponse response = new HelloResponse();
        response.setName("null");
        response.setAge(0);
        return response;
    }
}
