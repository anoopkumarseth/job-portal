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
import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UsersDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "{id}")
    public UsersDTO getUsersById(@PathVariable("id") Long userId){
            return userService.getUserById(userId);
    }

    @PostMapping
    public UsersDTO createNewUser(@RequestBody UsersDTO usersDTO){
        return userService.createNewUser(usersDTO);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteUserById(@PathVariable("id") Long delID){
        return userService.deleteUser(delID);
    }


}
