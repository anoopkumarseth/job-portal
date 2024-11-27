package com.jobportal.forMCA.job_search_engine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationID;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private JobEntity job;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private String resume;
    private String salary;
    private LocalDate applicationDate;
    private Boolean status;
}

