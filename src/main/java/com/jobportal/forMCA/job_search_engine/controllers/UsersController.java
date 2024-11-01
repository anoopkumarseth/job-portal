package com.jobportal.forMCA.job_search_engine.controllers;

//Operations
//GET
//POST
//DELETE

import com.jobportal.forMCA.job_search_engine.dto.UsersDTO;
import com.jobportal.forMCA.job_search_engine.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users/{id}")
    public UsersDTO getUsersById(@PathVariable("id") Long userId){
//        return new UsersDTO(userId, "Anoop Seth", "anoopseth@gmail.com", "AnoopSeth@123", LocalDate.of(2024,1,3), true); // for represent data
            return userService.getUserById(userId);
    }

    @GetMapping(path = "/users2/{id}")
    public UsersDTO getData(@PathVariable("id") Long userId, @PathParam("sortBy") String sortBy, @PathParam("sortBy") String age){
        return new UsersDTO(userId, "Anoop Seth", "anoopseth@gmail.com", sortBy + " " + age, LocalDate.of(2024,1,3), true);
    }
    @PostMapping(path = "/users2/{id}")
    public UsersDTO createNewUser(@RequestBody UsersDTO usersDTO){
        return userService.createNewUser(usersDTO);
    }
}
