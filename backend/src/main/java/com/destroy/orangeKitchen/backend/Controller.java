package com.destroy.orangeKitchen.backend;

import com.destroy.orangeKitchen.backend.entity.Booking;
import com.destroy.orangeKitchen.backend.entity.User;
import com.destroy.orangeKitchen.backend.service.booking.IBookingService;
import com.destroy.orangeKitchen.backend.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private IUserService userService;

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/getUserByEmail")
    public User user(@RequestParam(value = "email") String email) {
        List<User> users = userService.findAll();
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getEmail().equals(email)){
                return users.get(i);
            }
        }
        return null;
    }

    @GetMapping("/getUserById")
    public Optional<User> userById(@RequestParam(value = "id") String id) {
        return userService.getUserById(Long.valueOf(id));
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


    /*
    EXAMPLE:

    curl -X POST \
      http://localhost:8080/deleteUser?email=test@gmail.com
      }'
    */
    @PostMapping("/deleteUser")
    public void deleteUser(@RequestParam(value = "email") String email){
        List<User> users = userService.findAll();
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getEmail().equals(email)){
                userService.deleteUser(users.get(i));
            }
        }
    }

    /*
      EXAMPLE - add a new booking

      curl -X POST \
      http://localhost:8080/setBooking \
      -H 'cache-control: no-cache' \
      -H 'content-type: application/json' \
      -d '{
      "userId":"1",
      "month":"6",
      "day":"22",
      "startTime":"11:50",
      "endTime":"13:30",
      "event":"Batman"
      }'
    */

    /*
      EXAMPLE - update a booking (with id 4)

      curl -X POST \
      http://localhost:8080/setBooking \
      -H 'cache-control: no-cache' \
      -H 'content-type: application/json' \
      -d '{
      "id":"4",
      "userId":"1",
      "month":"6",
      "day":"22",
      "startTime":"11:50",
      "endTime":"13:30",
      "event":"Batman"
      }'
    */

    @PostMapping("/setBooking")
    public void addBooking(@RequestBody Booking booking){
        bookingService.makeBooking(booking);
    }

    @GetMapping("/getBookings")
    public List<Booking> getAllBooking(){
        return bookingService.findAll();
    }

    @GetMapping("/getBooking")
    public List<Booking> getBooking(@RequestParam(value = "userId") String userId){
        return bookingService.getUserBookings(userId);
    }

    /*
      EXAMPLE - Delete a booking

      curl -X POST \
      http://localhost:8080/deleteBooking \
      -H 'cache-control: no-cache' \
      -H 'content-type: application/json' \
      -d '{
      "id":"13",
      "userId":"1027",
      "month":"6",
      "day":"22",
      "startTime":"11:50",
      "endTime":"13:30",
      "event":"Batman"
      }'
    */
    @PostMapping("/deleteBooking")
    public void deleteBooking(@RequestBody Booking booking){
        bookingService.deleteBooking(booking);
    }

}
