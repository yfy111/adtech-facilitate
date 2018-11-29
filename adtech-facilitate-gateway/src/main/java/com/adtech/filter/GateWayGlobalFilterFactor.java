package com.adtech.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GateWayGlobalFilterFactor extends AbstractGatewayFilterFactory<GateWayGlobalFilterFactor.Config> {
    @Override
    public GatewayFilter apply(Config config) {
        return this::filter;
    }

    public GateWayGlobalFilterFactor() {
        super(Config.class);
    }

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);
    }

    public static class Config {

    }

    @Override
    public String name() {
        return "GateWayGlobalFilterFactor";
    }
}
