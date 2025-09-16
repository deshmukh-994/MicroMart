package com.inventory.userservice.service;

import com.inventory.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User register(User user);
    List<User> getAllUsers();
    Optional<User> getUserByEmail(String email);
    public String login(String email, String password);
    
}
