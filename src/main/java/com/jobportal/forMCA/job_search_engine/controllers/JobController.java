package com.jobportal.forMCA.job_search_engine.controllers;

//Operations
//GET
//POST
//DELETE

import com.jobportal.forMCA.job_search_engine.dto.JobDTO;
import com.jobportal.forMCA.job_search_engine.services.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobDTO> getAllUsers(){
        return jobService.getAllUsers();
    }

    @GetMapping(path = "{id}")
    public JobDTO getUsersById(@PathVariable("id") Long userId){
            return jobService.getUserById(userId);
    }

    @PostMapping
    public JobDTO createNewUser(@RequestBody JobDTO jobDTO){
        return jobService.createNewUser(jobDTO);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteUserById(@PathVariable("id") Long delID){
        return jobService.deleteUser(delID);
    }


}
