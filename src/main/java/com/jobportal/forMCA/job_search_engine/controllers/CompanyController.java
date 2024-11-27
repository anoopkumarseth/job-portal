package com.jobportal.forMCA.job_search_engine.controllers;


import com.jobportal.forMCA.job_search_engine.dto.ApplicationDTO;
import com.jobportal.forMCA.job_search_engine.dto.CompanyDTO;
import com.jobportal.forMCA.job_search_engine.services.ApplicationService;
import com.jobportal.forMCA.job_search_engine.services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyDTO> getAllApplication(){
        return companyService.getAllApplication();
    }

    @GetMapping(path = "{id}")
    public CompanyDTO getApplicationById(@PathVariable("id") Long applicationId){
            return companyService.getApplicationById(applicationId);
    }

    @PostMapping
    public CompanyDTO createNewApplication(@RequestBody CompanyDTO companyDTO){
        return companyService.createNewApplication(companyDTO);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteApplicationById(@PathVariable("id") Long delID){
        return companyService.deleteApplication(delID);
    }


}
