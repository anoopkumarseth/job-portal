package com.jobportal.forMCA.job_search_engine.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String title;
    private String description;
    private String location;
    private String salary;
    private LocalDate createdAt;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApplicationEntity> applications;
}
