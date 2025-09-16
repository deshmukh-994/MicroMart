package com.inventory.userservice.service;

import com.inventory.userservice.model.User;
import com.inventory.userservice.repository.IUserRepository;
import com.inventory.userservice.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}


    @Override
    public User register(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String login(String email, String password) {
        return userRepository.findByEmail(email)
        .filter(u -> new BCryptPasswordEncoder().matches(password, u.getPassword()))
        .map(u -> jwtUtil.generateToken(u.getEmail()))
        .orElseThrow(() -> new RuntimeException("Invalid email or password"));
}
}
