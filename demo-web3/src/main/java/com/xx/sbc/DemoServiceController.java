package com.xx.sbc;

import com.xx.sbc.web1.facade.DemoServiceFacade;
import com.xx.sbc.web1.request.HelloRequest;
import com.xx.sbc.web1.response.HelloResponse;
import com.xx.sbc.web2.facade.Web2ServiceFacade;
import com.xx.sbc.web2.utils.RibbonClientManager;
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
public class DemoServiceController implements DemoServiceFacade {

    @Autowired
    private Web2ServiceFacade web2ServiceFacade;

    @Override
    @GetMapping("/get")
    public HelloResponse get(@RequestParam("id") Long id) {
//        HelloResponse response = new HelloResponse();

//        String availableServerUrl = RibbonClientManager.getManager().getAvailableServerUrl("demo-feign-service");
//        System.out.println(availableServerUrl);
        HelloRequest request = new HelloRequest();
        request.setName("availableServerUrl");
        return web2ServiceFacade.add(request);
    }
}
