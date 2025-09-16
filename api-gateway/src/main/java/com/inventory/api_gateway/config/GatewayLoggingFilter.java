package com.inventory.api_gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayLoggingFilter {
    @Bean
    public GlobalFilter logRequestHeaders() {
        return (exchange, chain) -> {
            System.out.println("🔎 Incoming Request Path: " + exchange.getRequest().getURI());
            System.out.println("🔎 Authorization Header: " + exchange.getRequest().getHeaders().getFirst("Authorization"));
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("✅ Response Status: " + exchange.getResponse().getStatusCode());
            }));
        };
    }
}
