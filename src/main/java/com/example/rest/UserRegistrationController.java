package com.example.rest;

import com.example.model.UserRegistration;
import com.example.repo.UserRegistrationRepo;
import com.example.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRegistrationController {
    Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

    @Autowired
    UserRegistrationRepo userRepo;

    @GetMapping("/users")
    public List<UserRegistration> retrieveAllUsers(){
        logger.info("retrieveAllUsers() -- called");
       return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public UserRegistration getUserById(@PathVariable int id){
        UserRegistration user = userRepo.findById(id).orElse(null);
        if(user==null){
            throw new UserNotFoundException("User not found for id : "+id);
        }
        return user;
    }

    @PostMapping("/user")
    public List<UserRegistration> saveUser(@RequestBody UserRegistration user){
       UserRegistration u = user;
       u.setRegistrationDate(new Date());
        userRepo.save(u);
        return retrieveAllUsers();
    }

    @GetMapping("/")
    public String displayPodName() throws UnknownHostException {
        return "Pod Name is " +java.net.InetAddress.getLocalHost();
    }
}
