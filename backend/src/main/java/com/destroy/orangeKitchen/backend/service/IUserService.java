package com.destroy.orangeKitchen.backend.service;

import com.destroy.orangeKitchen.backend.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void addUser(User user);
}
