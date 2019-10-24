package com.xx.sbc.web2.utils;

import com.netflix.client.ClientFactory;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import com.xx.sbc.web2.facade.Web2ServiceFacade;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.LBClient;
import feign.ribbon.LBClientFactory;
import feign.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FeignConfiguration {

//    public FeignConfiguration() {
//        try {
//            ConfigurationManager.loadPropertiesFromResources("sample-client.properties");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    @Bean
//    public Web2ServiceFacade web2ServiceFacade() {
//
//        RibbonClient client = RibbonClient.builder().lbClientFactory(new LBClientFactory() {
//
//            @Override
//            public LBClient create(String clientName) {
//                IClientConfig config = ClientFactory.getNamedConfig(clientName);
////                ILoadBalancer lb = ClientFactory.getNamedLoadBalancer(clientName);
//                ILoadBalancer lb = RibbonClientManager.getManager().getLoadBalancer("demo-feign-service");
//                ZoneAwareLoadBalancer zb = (ZoneAwareLoadBalancer) lb;
//                zb.setRule(zoneAvoidanceRule());
//                return LBClient.create(lb, config);
//            }
//        }).build();
//
//        Web2ServiceFacade service = Feign.builder().client(client).encoder(new JacksonEncoder())
//                .decoder(new JacksonDecoder()).target(Web2ServiceFacade.class, "http://demo-feign-service");
//
//        return service;
//    }

    /**
     * Ribbon负载均衡策略实现
     * 使用ZoneAvoidancePredicate和AvailabilityPredicate来判断是否选择某个server，前一个判断判定一个zone的运行性能是否可用，
     * 剔除不可用的zone（的所有server），AvailabilityPredicate用于过滤掉连接数过多的Server。
     *
     * @return
     */
    private IRule zoneAvoidanceRule() {
        return new ZoneAvoidanceRule();
    }

    /**
     * Ribbon负载均衡策略实现
     * 随机选择一个server。
     *
     * @return
     */
    private IRule randomRule() {
        return new RandomRule();
    }
}