package com.xx.sbc;

import com.xx.sbc.facade.HelloRequest;
import com.xx.sbc.facade.HelloResponse;
import com.xx.sbc.facade.Web2ServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@Slf4j
@RestController
@RequestMapping("web1/module1")
public class DemoServiceController {

    @Autowired
    private Web2ServiceFacade web2ServiceFacade;

    @GetMapping("/get")
    public HelloResponse get(@RequestParam("id") Long id) {
//        HelloResponse response = new HelloResponse();
        HelloRequest request = new HelloRequest();
        request.setName("sdf");
        return web2ServiceFacade.add(request);
    }
}
