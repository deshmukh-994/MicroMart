package com.inventory.userservice.controller;

import com.inventory.userservice.model.User;
import com.inventory.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/email/{email}")
    public User getByEmail(@PathVariable String email) {
        return service.getUserByEmail(email).orElse(null);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
    String token = service.login(loginRequest.getEmail(), loginRequest.getPassword());
    return ResponseEntity.ok(token);
}

}
