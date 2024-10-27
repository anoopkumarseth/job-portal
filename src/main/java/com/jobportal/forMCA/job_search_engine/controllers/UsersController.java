package com.jobportal.forMCA.job_search_engine.controllers;

//Operations
//GET
//POST
//DELETE

import com.jobportal.forMCA.job_search_engine.dto.UsersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class UsersController {

    @GetMapping(path = "/users")
    public UsersDTO getUsers(){
        return new UsersDTO(25L, "Anoop Seth", "anoopseth@gmail.com", "AnoopSeth@123", LocalDate.of(2024,1,3), true);
    }
}
