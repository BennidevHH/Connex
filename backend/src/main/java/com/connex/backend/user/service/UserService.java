package com.connex.backend.user.service;

import com.connex.backend.user.dto.UserDto;
import com.connex.backend.user.model.User;
import com.connex.backend.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String username, String rawPassword, String email){
        User u = new User();
        u.setUsername(username);
        u.setPasswordHash(passwordEncoder.encode(rawPassword));
        u.setEmail(email);
        return userRepository.save(u);
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
