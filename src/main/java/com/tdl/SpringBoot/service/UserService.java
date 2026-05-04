package com.tdl.SpringBoot.service;

import com.tdl.SpringBoot.dto.request.UserCreationRequest;
import com.tdl.SpringBoot.dto.request.UserUpdateRequest;
import com.tdl.SpringBoot.entity.User;
import com.tdl.SpringBoot.repository.UserRepositorry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private  UserRepositorry userRepositorry;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if (userRepositorry.existsByUsername(request.getUsername()))
            throw new RuntimeException("user exists");

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepositorry.save(user);
    }

    public List<User> getUsers() {
        return userRepositorry.findAll();
    }

    public User getUsers(String id) {
        return userRepositorry.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUsers(userId);

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepositorry.save(user);
    }

    public void deleteUser(String userId) {
        userRepositorry.deleteById(userId);
    }
}
