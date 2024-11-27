package com.jobportal.forMCA.job_search_engine.services;

import com.jobportal.forMCA.job_search_engine.dto.ApplicationDTO;
import com.jobportal.forMCA.job_search_engine.dto.CompanyDTO;
import com.jobportal.forMCA.job_search_engine.entities.ApplicationEntity;
import com.jobportal.forMCA.job_search_engine.entities.CompanyEntity;
import com.jobportal.forMCA.job_search_engine.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    final CompanyRepository companyRepository;
    final ModelMapper modelMapper;

    public CompanyService(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    public List<CompanyDTO> getAllApplication() {
        return companyRepository
                .findAll()
                .stream()
                .map(applicationEntity -> modelMapper.map(applicationEntity, CompanyDTO.class))
                .collect(Collectors.toList());
    }

    public CompanyDTO getApplicationById(long id){
        CompanyEntity applicationEntity = companyRepository.getById(id);
        return modelMapper.map(applicationEntity, CompanyDTO.class);
    }

    public CompanyDTO createNewApplication(CompanyDTO applicationDTO) {
        CompanyEntity applicationEntity = modelMapper.map(applicationDTO, CompanyEntity.class);
        return modelMapper.map(companyRepository.save(applicationEntity), CompanyDTO.class);
    }


    public boolean deleteApplication(Long delID) {
        boolean isPresent =  companyRepository.existsById(delID);
        if(!isPresent) return false;
        companyRepository.deleteById(delID);
        return true;

    }
}
