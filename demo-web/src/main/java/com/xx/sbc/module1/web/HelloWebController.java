package com.xx.sbc.module1.web;

import com.xx.sbc.module1.service.HelloService;
import com.xx.sbc.web1.response.HelloResponse;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@RestController
@RequestMapping("web1/module1")
//@Api(value = "value", tags = "xxx模块功能")
public class HelloWebController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
//    @ApiOperation(value = "value", notes = "notes")
    public HelloResponse hello(@RequestParam("id") Long id) {
        return helloService.hello(id);
    }
}
