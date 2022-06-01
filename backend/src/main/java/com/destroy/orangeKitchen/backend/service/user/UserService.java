package com.destroy.orangeKitchen.backend.service.user;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void deleteUser(User user){
        repository.delete(user);
    }

    @Override
    public Optional<User> getUserById(Long id){
        return repository.findById(id);
    }

    public void addUser(User user){
        repository.save(user);
    }
}
