package com.college.app.controller;

import com.college.app.model.User;
import com.college.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

// __________________________User Creation Endpoints ____________________________________________//
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping // getting all the users from the database
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    // __________________________User Creation Endpoints ____________________________________________//
}
