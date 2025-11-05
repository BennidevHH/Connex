package com.connex.backend.user.controller;

import com.connex.backend.user.dto.AuthRequest;
import com.connex.backend.user.dto.AuthResponse;
import com.connex.backend.user.service.UserService;
import com.connex.backend.user.repository.UserRepository;
import com.connex.backend.user.model.User;
import com.connex.backend.security.jwt.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, UserService userService, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid AuthRequest req){
        if(userRepository.existsByUsername(req.getUsername())){
            return ResponseEntity.badRequest().body(java.util.Map.of("error","username_taken"));
        }
        User u = userService.createUser(req.getUsername(), req.getPassword(), null);
        return ResponseEntity.ok(java.util.Map.of("status","created", "id", u.getId()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest req){
        return userRepository.findByUsername(req.getUsername())
                .map(u -> {
                    if(userService != null && org.springframework.security.crypto.bcrypt.BCrypt.checkpw(req.getPassword(), u.getPasswordHash())) {
                        String token = jwtUtil.generateToken(u.getUsername(), List.of(u.getRole()));
                        return ResponseEntity.ok(new AuthResponse(token));
                    } else {
                        return ResponseEntity.status(401).body(java.util.Map.of("error","invalid_credentials"));
                    }
                }).orElse(ResponseEntity.status(401).body(java.util.Map.of("error","invalid_credentials")));
    }
}
