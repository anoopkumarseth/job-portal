package com.jobportal.forMCA.job_search_engine.controllers;


import com.jobportal.forMCA.job_search_engine.dto.ApplicationDTO;
import com.jobportal.forMCA.job_search_engine.services.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<ApplicationDTO> getAllApplication(){
        return applicationService.getAllApplication();
    }

    @GetMapping(path = "{id}")
    public ApplicationDTO getApplicationById(@PathVariable("id") Long applicationId){
            return applicationService.getApplicationById(applicationId);
    }

    @PostMapping
    public ApplicationDTO createNewApplication(@RequestBody ApplicationDTO applicationDTO){
        return applicationService.createNewApplication(applicationDTO);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteApplicationById(@PathVariable("id") Long delID){
        return applicationService.deleteApplication(delID);
    }


}
