package com.jobportal.forMCA.job_search_engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private Long companyID;
    private String name;
    private String description;
    private String location;
    private String website;
    private LocalDate createdAt;
    private Boolean status;
}
