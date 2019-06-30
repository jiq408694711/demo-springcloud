package com.xx.sbc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@Component
public class TokenAuthFilter implements GlobalFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        LOGGER.info("GATEWAY REQUEST, url:{}, from:{}", serverWebExchange.getRequest().getPath(), serverWebExchange.getRequest().getRemoteAddress());
        String token = serverWebExchange.getRequest().getQueryParams().getFirst("token");
        if (!authValid(token)) {
            serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return serverWebExchange.getResponse().setComplete();
        }
        return gatewayFilterChain.filter(serverWebExchange);
    }

    private boolean authValid(String token) {
        if (token == null || token.isEmpty()) {
            return true;
//            return false;
        }

        //TODO valid token
        return true;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
