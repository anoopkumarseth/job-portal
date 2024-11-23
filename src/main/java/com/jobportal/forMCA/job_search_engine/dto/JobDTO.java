package com.jobportal.forMCA.job_search_engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
    private Long jobId;
    private String title;
    private String description;
    private String location;
    private String companyID;
    private String salary;
    private LocalDate createdAt;
    @JsonProperty("status")
    private Boolean status;
}
