package com.xx.sbc.web1.facade;

import com.xx.sbc.web1.response.HelloResponse;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiyiqin on 2019/6/29.
 */
//@FeignClient(value = "demo-feign-service", path = "web1/module1")
//@FeignClient(value = "demo-feign-service", path = "web1/module1", fallback = DemoServiceFacadeFallback.class)
public interface DemoServiceFacade {

    @PostMapping("/get")
    HelloResponse get(@RequestParam("id") Long id);
}
