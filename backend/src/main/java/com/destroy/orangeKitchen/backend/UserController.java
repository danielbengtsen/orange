package com.destroy.orangeKitchen.backend;

import com.destroy.orangeKitchen.backend.entity.User;
import com.destroy.orangeKitchen.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getUser")
    public User user(@RequestParam(value = "email") String email) {
        List<User> users = userService.findAll();
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getEmail().equals(email)){
                return users.get(i);
            }
        }
        return null;
    }

    @GetMapping("/getUsers")
    public List<User> users() {
        return userService.findAll();
    }
    /*
      EXAMPLE - add new user

      curl -X POST \
      http://localhost:8080/setUser \
      -H 'cache-control: no-cache' \
      -H 'content-type: application/json' \
      -d '{
      "userName":"test",
      "email":"test@gmail.com",
      "kitchen":"orange",
      "originals":"no",
      "passwordHash":"klhjui"
      }'
    */

    /*
      EXAMPLE - update a user (with id 4)

      curl -X POST \
      http://localhost:8080/setUser \
      -H 'cache-control: no-cache' \
      -H 'content-type: application/json' \
      -d '{
      "id":"4",
      "userName":"test",
      "email":"test@gmail.com",
      "kitchen":"orange",
      "originals":"no",
      "passwordHash":"klhjui"
      }'
    */
    @PostMapping("/setUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

}
