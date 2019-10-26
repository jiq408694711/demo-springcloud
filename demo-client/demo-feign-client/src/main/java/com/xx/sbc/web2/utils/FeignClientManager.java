package com.xx.sbc.web2.utils;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class FeignClientManager {

    private static Feign.Builder builder;

    static {
        builder = Feign.builder()
                .options(new Request.Options(1000, 3500))   // 设置连接超时时长及响应超时时长
                .retryer(Retryer.NEVER_RETRY)    // 重试策略
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder());
    }

    public static <T> T getApiClient(Class<T> apiType, String applicationName) {
        return builder
                .client(RibbonClientManager.instance(applicationName))
                .target(apiType, "http://" + applicationName);
    }
}