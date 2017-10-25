package com.test.spring.boot.service;

import com.test.spring.boot.model.User;
import com.test.spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long userId) {
        User user = userRepository.findOne(userId);
        return user;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser (User user, User userDetails) {
        user.setType(userDetails.getType());
        user.setName(userDetails.getName());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(long userId) {
        userRepository.delete(userId);
    }
}