package com.mehdi.resetfullprojectspringboot.services;

import com.mehdi.resetfullprojectspringboot.models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
