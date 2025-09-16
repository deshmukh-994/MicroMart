package com.inventory.userservice.repository;

import com.inventory.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    User save(User user);
    List<User> findAll();
    Optional<User> findByEmail(String email);
}
