package com.test.spring.boot.repository;


import com.test.spring.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByLogin(String login);
}

