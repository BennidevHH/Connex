package com.connex.backend.websocket;

import com.connex.backend.security.jwt.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.WebSocketHandler;

import java.util.Map;

public class JwtHandshakeInterceptor implements HandshakeInterceptor {

    private final JwtUtil jwtUtil;

    public JwtHandshakeInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        var params = request.getURI().getQuery();
        if (params != null && params.contains("token=")) {
            String token = null;
            for (String p : params.split("&")) {
                if (p.startsWith("token=")) { token = p.substring(6); break; }
            }
            if(token != null) {
                try {
                    var claims = jwtUtil.validateAndParse(token);
                    attributes.put("username", claims.getBody().getSubject());
                    return true;
                } catch (JwtException ex) {
                    return false;
                }
            }
        }
        return false; // require token for WS connections
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception exception) {}
}
