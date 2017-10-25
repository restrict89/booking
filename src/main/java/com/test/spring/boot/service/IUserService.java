package com.test.spring.boot.service;

import com.test.spring.boot.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getUserById(long userId);

    void addUser(User user);

    void updateUser(User user, User userDetails);

    void deleteUser (long userId);
}
