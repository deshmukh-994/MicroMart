package com.inventory.api_gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("userservice", r -> r.path("/userservice/**")
                .filters(f -> f.stripPrefix(1).filter(jwtAuthFilter)) // ✅ JWT filter added
                .uri("lb://USERSERVICE"))
            .build();
    }
}
