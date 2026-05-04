package com.tdl.SpringBoot.controller;

import com.tdl.SpringBoot.dto.request.UserCreationRequest;
import com.tdl.SpringBoot.dto.request.UserUpdateRequest;
import com.tdl.SpringBoot.entity.User;
import com.tdl.SpringBoot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId){
        return userService.getUsers(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been delete";
    }
}
