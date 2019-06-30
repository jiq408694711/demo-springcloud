package com.xx.sbc.module1.service;

import com.xx.sbc.web1.facade.DemoServiceFacade;
import com.xx.sbc.web1.response.HelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@Service
public class HelloService {

    @Autowired
    private DemoServiceFacade demoServiceFacade;

    public HelloResponse hello(Long id) {
        return demoServiceFacade.get(id);
    }
}
