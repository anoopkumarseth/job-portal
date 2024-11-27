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
    public List<JobDTO> getAllJob(){
        return jobService.getAllJob();
    }

    @GetMapping(path = "{id}")
    public JobDTO getJobById(@PathVariable("id") Long jobId){
            return jobService.getJobById(jobId);
    }

    @PostMapping
    public JobDTO createNewJob(@RequestBody JobDTO jobDTO){
        return jobService.createNewJob(jobDTO);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteJobById(@PathVariable("id") Long delID){
        return jobService.deleteJob(delID);
    }


}
