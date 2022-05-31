package com.destroy.orangeKitchen.backend.service;
import java.util.List;

import com.destroy.orangeKitchen.backend.entity.User;
import com.destroy.orangeKitchen.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository repository;


    @Override
    public List<User> findAll() {
        var users = (List<User>) repository.findAll();
        return users;
    }

    public void addUser(User user){
        repository.save(user);
    }
}
