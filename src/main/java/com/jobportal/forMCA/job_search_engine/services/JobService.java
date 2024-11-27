package com.jobportal.forMCA.job_search_engine.services;

import com.jobportal.forMCA.job_search_engine.dto.JobDTO;
import com.jobportal.forMCA.job_search_engine.entities.JobEntity;
import com.jobportal.forMCA.job_search_engine.repositories.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    final JobRepository jobRepository;
    final ModelMapper modelMapper;

    public JobService(JobRepository JobRepository, ModelMapper modelMapper) {
        this.jobRepository = JobRepository;
        this.modelMapper = modelMapper;
    }

    public List<JobDTO> getAllJob() {
        return jobRepository
                .findAll()
                .stream()
                .map(jobEntity -> modelMapper.map(jobEntity, JobDTO.class))
                .collect(Collectors.toList());
    }

    public JobDTO getJobById(long id){
        JobEntity jobEntity = jobRepository.getById(id);
        return modelMapper.map(jobEntity, JobDTO.class);
    }

    public JobDTO createNewJob(JobDTO jobDTO) {
        JobEntity jobEntity = modelMapper.map(jobDTO, JobEntity.class);
        return modelMapper.map(jobRepository.save(jobEntity), JobDTO.class);
    }


    public boolean deleteJob(Long delID) {
        boolean isPresent =  jobRepository.existsById(delID);
        if(!isPresent) return false;
        jobRepository.deleteById(delID);
        return true;

    }
}
