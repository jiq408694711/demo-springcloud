package com.xx.sbc.module1.ws;

import com.xx.sbc.web1.request.HelloRequest;
import com.xx.sbc.web1.response.HelloResponse;
import com.xx.sbc.web2.facade.Web2ServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@Slf4j
@RestController
@RequestMapping("feign/test")
public class FeignTestController implements Web2ServiceFacade {

//    @Override
//    @GetMapping("/get")
//    public HelloResponse get(@RequestParam("id") Long id) {
//        HelloResponse response = new HelloResponse();
//        response.setName("hello sbc-id-" + id);
//        response.setAge(18);
//        return response;
//    }

    @Override
    @PostMapping("add")
    public HelloResponse add(@RequestBody HelloRequest request) {
        HelloResponse response = new HelloResponse();
        response.setName("hello sbc-id-new");
        response.setAge(18);
        return response;
    }

//    @Override
//    @PostMapping("add2")
//    public HelloResponse add2(@RequestParam("id") Long id, @RequestBody HelloRequest request) {
//        HelloResponse response = new HelloResponse();
//        response.setName("hello sbc-id-new2");
//        response.setAge(18);
//        return response;
//    }
}
