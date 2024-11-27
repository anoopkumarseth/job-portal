package com.jobportal.forMCA.job_search_engine.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyID;

    private String name;
    private String description;
    private String location;
    private String website;
    private LocalDate createdAt;
    private Boolean status;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobEntity> jobs;

    @ManyToMany(mappedBy = "companies")
    private List<UserEntity> users;
}

