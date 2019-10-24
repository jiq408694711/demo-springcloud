package com.xx.sbc.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jiyiqin on 2019/6/30.
 */
@FeignClient(value = "demo-feign-service")
public interface Web2ServiceFacade {

    //    @Headers({"Content-Type: application/json","Accept: application/json"})
//    @RequestLine("GET /feign/test/get")
//    @GetMapping("/feign/test/get")
//    @Headers("Content-Type: application/json")
//    HelloResponse get(@RequestParam("id") Long id);

    //    @PostMapping("/feign/test/add")
    @RequestMapping(value = "/feign/test/add", method = RequestMethod.POST)
//    @Headers("Content-Type: application/json;charset=UTF-8")
    HelloResponse add(@RequestBody HelloRequest request);

//    @RequestLine("POST /feign/test/add2")
//    @Headers("Content-Type: application/json;charset=UTF-8")
//    HelloResponse add2(@RequestParam("id") Long id, @RequestBody HelloRequest request);
}
