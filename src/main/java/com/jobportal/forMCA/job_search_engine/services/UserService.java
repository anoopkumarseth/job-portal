package com.jobportal.forMCA.job_search_engine.services;

import com.jobportal.forMCA.job_search_engine.dto.UsersDTO;
import com.jobportal.forMCA.job_search_engine.entities.UserEntity;
import com.jobportal.forMCA.job_search_engine.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserService {

    final UserRepository userRepository;
    final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UsersDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userEntity -> modelMapper.map(userEntity, UsersDTO.class))
                .collect(Collectors.toList());
    }

    public UsersDTO getUserById(long id){
        UserEntity userEntity = userRepository.getById(id);
        return modelMapper.map(userEntity, UsersDTO.class);
    }

    public UsersDTO createNewUser(UsersDTO usersDTO) {
        UserEntity userEntity = modelMapper.map(usersDTO, UserEntity.class);
        return modelMapper.map(userRepository.save(userEntity), UsersDTO.class);
    }


    public boolean deleteUser(Long delID) {
        boolean isPresent =  userRepository.existsById(delID);
        if(!isPresent) return false;
        userRepository.deleteById(delID);
        return true;

    }
}
