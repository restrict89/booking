package com.test.spring.boot.controller;


import com.test.spring.boot.model.User;
import com.test.spring.boot.model.UserType;
import com.test.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasAuthority('LIBRARIAN')")
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        User book = userService.getUserById(userId);
        return book;
    }

    @PreAuthorize("hasAuthority('LIBRARIAN')")
    @GetMapping("/allUsers")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @PreAuthorize("hasAuthority('LIBRARIAN')")
    @PostMapping("/add")
    public void addUser(@RequestParam("name") String name, @RequestParam("type") String type,
                        @RequestParam("login") String login, @RequestParam("password") String password) {
        User newUser = new User();
        UserType userType =type.equals("LIBRARIAN") ? UserType.LIBRARIAN : type.equals("READER") ? UserType.READER : null;
        if (userType != null) {
            newUser.setName(name);
            newUser.setType(userType);
            newUser.setLogin(login);
            newUser.setPassword(password);
            userService.addUser(newUser);
        }
    }

    @PreAuthorize("hasAuthority('LIBRARIAN')")
    @PutMapping("user")
    public User updateUser(@PathVariable(value = "id") Long userId,
                           @Valid @RequestBody User userDetails) {
        User book = userService.getUserById(userId);
        userService.updateUser(book, userDetails);
        return book;
    }

    @PreAuthorize("hasAuthority('LIBRARIAN')")
    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId) {
        User book = userService.getUserById(userId);
        if (book != null) {
            userService.deleteUser(userId);
        }
    }
}
