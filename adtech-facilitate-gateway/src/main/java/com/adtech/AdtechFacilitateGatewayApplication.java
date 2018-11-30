package com.adtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdtechFacilitateGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdtechFacilitateGatewayApplication.class, args);
    }
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/user/**")
                        .uri("http://localhost:8765"))
                .route("host_route", r -> r.path("/dictionaries/**")
                        .uri("http://localhost:8766"))
                .build();
    }
}
