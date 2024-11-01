package com.jobportal.forMCA.job_search_engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private LocalDate createdAt;

    @JsonProperty("isActive")
    private Boolean isActive;
}
