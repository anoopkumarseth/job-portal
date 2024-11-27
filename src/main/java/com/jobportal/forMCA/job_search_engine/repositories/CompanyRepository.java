package com.jobportal.forMCA.job_search_engine.repositories;

import com.jobportal.forMCA.job_search_engine.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
