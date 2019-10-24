package com.xx.sbc.web2.facade;

import com.xx.sbc.web1.request.HelloRequest;
import com.xx.sbc.web1.response.HelloResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiyiqin on 2019/6/30.
 */
@Headers("Accept: application/json")
public interface Web2ServiceFacade {

    //    @Headers({"Content-Type: application/json","Accept: application/json"})
//    @RequestLine("GET /feign/test/get")
//    @GetMapping("/feign/test/get")
//    @Headers("Content-Type: application/json")
//    HelloResponse get(@RequestParam("id") Long id);

    @RequestLine("POST /feign/test/add")
    @Headers("Content-Type: application/json;charset=UTF-8")
    HelloResponse add(@RequestBody HelloRequest request);

//    @RequestLine("POST /feign/test/add2")
//    @Headers("Content-Type: application/json;charset=UTF-8")
//    HelloResponse add2(@RequestParam("id") Long id, @RequestBody HelloRequest request);
}
