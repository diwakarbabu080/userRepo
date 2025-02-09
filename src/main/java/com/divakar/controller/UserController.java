package com.divakar.controller;


import com.divakar.entity.User;
import com.divakar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "https://diwakaruserdemo.netlify.app")


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/fetch")
    public List<User> fetchAndStoreUsers() {
        return userService.fetchAndSaveUsers();
    }
    /**
     * b. List all users based on role.
     */
    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }

    /**
     * c. List of users sorted by age (asc/desc).
     */
    @GetMapping("/sorted-by-age/{order}")
    public List<User> getUsersSortedByAge(@PathVariable String order) {
        return userService.getUsersSortedByAge(order);
    }

    /**
     * d. Find a specific user by ID or SSN.
     */
    @GetMapping("/{idOrSsn}")
    public Optional<User> getUserByIdOrSSN(@PathVariable String idOrSsn) {
        try {
            Long id = Long.parseLong(idOrSsn);
            return userService.getUserByIdOrSSN(id, null);
        } catch (NumberFormatException e) {
            return userService.getUserByIdOrSSN(null, idOrSsn);
        }
    }
    /**
     * e. List users by role and sort them by age.
     */
    @GetMapping("/role/{role}/sorted-by-age/{order}")
    public List<User> getUsersByRoleAndSortedByAge(@PathVariable String role, @PathVariable String order) {
        return userService.getUsersByRoleAndSortedByAge(role, order);
    }

}