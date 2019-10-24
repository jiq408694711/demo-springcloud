package com.xx.sbc.module1.service;

import com.xx.sbc.web1.facade.DemoServiceFacade;
import com.xx.sbc.web1.request.HelloRequest;
import com.xx.sbc.web1.response.HelloResponse;
import com.xx.sbc.web2.utils.FeignClientManager;
import com.xx.sbc.web2.facade.Web2ServiceFacade;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@Service
public class HelloService {

//    @Autowired
//    private DemoServiceFacade demoServiceFacade;

    @Autowired
    private Web2ServiceFacade web2ServiceFacade;

    public HelloResponse hello(Long id) {
//        if (id == 0) {
//            Web2ServiceFacade facade = FeignClientManager.getApiClient(Web2ServiceFacade.class, "demo-feign-service");
//        Web2ServiceFacade facade = Feign.builder()
//                .decoder(new JacksonDecoder())
//                .encoder(new JacksonEncoder())
//                .target(Web2ServiceFacade.class, "http://172.23.66.196:8073");

        HelloRequest request = new HelloRequest();
        request.setName("sdf");
        HelloResponse response = web2ServiceFacade.add(request);

//            return facade.get(id);
//        }
//        return demoServiceFacade.get(id);
        return response;
    }
}
