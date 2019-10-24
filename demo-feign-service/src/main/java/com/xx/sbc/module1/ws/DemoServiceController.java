package com.xx.sbc.module1.ws;

import com.alibaba.fastjson.JSON;
import com.xx.sbc.web1.facade.DemoServiceFacade;
import com.xx.sbc.web1.response.HelloResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@Slf4j
@RestController
@RequestMapping("web1/module1")
public class DemoServiceController implements DemoServiceFacade {

    @Override
    @GetMapping("/get")
    public HelloResponse get(@RequestParam("id") Long id) {
        HelloResponse response = new HelloResponse();
        response.setName("hello sbc-id-" + id);
        response.setAge(18);
//        LOGGER.info("response: {}", JSON.toJSONString(response));
        return response;
    }
}
