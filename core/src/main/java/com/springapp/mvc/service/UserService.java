package com.springapp.mvc.service;

import com.springapp.mvc.domain.User;

import java.util.List;


public interface UserService {

    void addUser(User user);

    User getUser(Long userId);

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);

    List<User> getAllUsers();

}
