package com.jobportal.forMCA.job_search_engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {
    private Long applicationID;
    private String jobID;
    private String userID;
    private String resume;
    private String salary;
    private LocalDate applicationDate;
    @JsonProperty("status")
    private Boolean status;
}
