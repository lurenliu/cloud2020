package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/4 14:51
 */
@Component
@Slf4j
public class MyLogGetWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("~~~~~~~~~~~~~~~~~~~~   come  in  MyLogGateWayFilter ~~~~~~~~~~~~~~~~");
        String name = exchange.getRequest().getQueryParams().getFirst("username");
        if(name == null){
            log.info("~~~~~~~~~~~  抱歉，您的username为 null，不能进入 ~~~~~~~~~ ");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
