package com.connex.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final com.connex.backend.security.jwt.JwtUtil jwtUtil;

    public WebSocketConfig(com.connex.backend.security.jwt.JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // simple broker for dev; replace with RabbitMQ / STOMP broker for scale
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOrigins("http://localhost:3000")
                .addInterceptors(new com.connex.backend.websocket.JwtHandshakeInterceptor(jwtUtil))
                .withSockJS();
    }
}
