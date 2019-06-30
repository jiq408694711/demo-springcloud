package com.xx.sbc.module1.ws;

import com.xx.sbc.web1.facade.DemoServiceFacade;
import com.xx.sbc.web1.response.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@RestController
@RequestMapping("web1/module1")
public class DemoServiceController implements DemoServiceFacade {

    @Override
    @GetMapping("/get")
    public HelloResponse get(Long id) {
        HelloResponse response = new HelloResponse();
        response.setName("hello sbc-id-" + id);
        response.setAge(18);
        return response;
    }
}
