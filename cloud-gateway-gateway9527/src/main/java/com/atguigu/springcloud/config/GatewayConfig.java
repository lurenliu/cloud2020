package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/1 23:58
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator consumerRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routers = builder.routes();
        routers.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routers.build();

//        routers.route("path_route_atguigu",
//                r -> r.path("/guonei")
//                        .uri("http://news.baidu.com/guonei")).build();
    }


}
