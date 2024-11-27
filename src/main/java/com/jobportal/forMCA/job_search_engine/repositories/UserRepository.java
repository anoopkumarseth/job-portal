package com.jobportal.forMCA.job_search_engine.repositories;

import com.jobportal.forMCA.job_search_engine.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmailAndPassword(String email, String password);
}
