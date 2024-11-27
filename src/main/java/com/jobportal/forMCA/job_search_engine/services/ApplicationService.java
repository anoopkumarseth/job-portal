package com.jobportal.forMCA.job_search_engine.services;

import com.jobportal.forMCA.job_search_engine.dto.ApplicationDTO;
import com.jobportal.forMCA.job_search_engine.entities.ApplicationEntity;
import com.jobportal.forMCA.job_search_engine.repositories.ApplicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    final ApplicationRepository applicationRepository;
    final ModelMapper modelMapper;

    public ApplicationService(ApplicationRepository applicationRepository, ModelMapper modelMapper) {
        this.applicationRepository = applicationRepository;
        this.modelMapper = modelMapper;
    }

    public List<ApplicationDTO> getAllApplication() {
        return applicationRepository
                .findAll()
                .stream()
                .map(jobEntity -> modelMapper.map(jobEntity, ApplicationDTO.class))
                .collect(Collectors.toList());
    }

    public ApplicationDTO getApplicationById(long id){
        ApplicationEntity jobEntity = applicationRepository.getById(id);
        return modelMapper.map(jobEntity, ApplicationDTO.class);
    }

    public ApplicationDTO createNewApplication(ApplicationDTO jobDTO) {
        ApplicationEntity jobEntity = modelMapper.map(jobDTO, ApplicationEntity.class);
        return modelMapper.map(applicationRepository.save(jobEntity), ApplicationDTO.class);
    }


    public boolean deleteApplication(Long delID) {
        boolean isPresent =  applicationRepository.existsById(delID);
        if(!isPresent) return false;
        applicationRepository.deleteById(delID);
        return true;

    }
}
