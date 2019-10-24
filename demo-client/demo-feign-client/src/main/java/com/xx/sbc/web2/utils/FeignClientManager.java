package com.xx.sbc.web2.utils;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

//import feign.okhttp.OkHttpClient;
//import feign.okhttp.OkHttpClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class FeignClientManager {

//    private final static Logger LOG = LoggerFactory.getLogger(FeignClientManager.class);

    private static Feign.Builder builder;

    static {
        builder = Feign.builder()
                .options(new Request.Options(1000, 3500))   // 设置连接超时时长及响应超时时长
                .retryer(Retryer.NEVER_RETRY)    // 重试策略
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder());
//                .client(new OkHttpClient());    //集成OKHTTPClient，可选
    }

    public static <T> T getApiClient(Class<T> apiType, String applicationName) {
//        LOG.info("try get {} api client ...", applicationName);
//        String availableServerUrl = RibbonClientManager.getManager().getAvailableServerUrl(applicationName);
//        LOG.info("get {} api host:{} ...", applicationName, availableServerUrl);

//        if (StringUtils.isEmpty(availableServerUrl)) {
//            LOG.error("get {} api host error! please check the eureka address or check the service of eureka !", applicationName);
//            throw new IllegalStateException("没有可用服务地址！");
//        }
//        return builder.target(apiType, availableServerUrl);
//        return builder.client(new LoadBalancerFeign()).target(new Target.HardCodedTarget<>(apiType, applicationName, "http://" + applicationName));

        return builder.client(RibbonClientManager.instance()).target(apiType, "http://" + applicationName);
    }

}