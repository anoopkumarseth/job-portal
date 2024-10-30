package com.jobportal.forMCA.job_search_engine.controllers;

//Operations
//GET
//POST
//DELETE

import com.jobportal.forMCA.job_search_engine.dto.UsersDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class UsersController {

    @GetMapping(path = "/users/{id}")
    public UsersDTO getUsers(@PathVariable("id") Long userId){
        return new UsersDTO(userId, "Anoop Seth", "anoopseth@gmail.com", "AnoopSeth@123", LocalDate.of(2024,1,3), true);
    }

    @GetMapping(path = "/users2/{id}")
    public UsersDTO getData(@PathVariable("id") Long userId, @PathParam("sortBy") String sortBy, @PathParam("sortBy") String age){
        return new UsersDTO(userId, "Anoop Seth", "anoopseth@gmail.com", sortBy + " " + age, LocalDate.of(2024,1,3), true);
    }
}
