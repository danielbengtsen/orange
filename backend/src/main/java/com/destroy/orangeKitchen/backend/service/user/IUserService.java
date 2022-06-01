package com.destroy.orangeKitchen.backend.service.user;

import com.destroy.orangeKitchen.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    void addUser(User user);
    Optional<User> getUserById(Long id);
    void deleteUser(User user);

}
