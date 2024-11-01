package com.jobportal.forMCA.job_search_engine.services;

import com.jobportal.forMCA.job_search_engine.dto.UsersDTO;
import com.jobportal.forMCA.job_search_engine.entities.UserEntity;
import com.jobportal.forMCA.job_search_engine.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;
    final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UsersDTO getUserById(long id){
        UserEntity userEntity = userRepository.getById(id);
        return modelMapper.map(userEntity, UsersDTO.class);
    }

    public UsersDTO createNewUser(UsersDTO usersDTO) {
        UserEntity userEntity = modelMapper.map(usersDTO, UserEntity.class);
        return modelMapper.map(userRepository.save(userEntity), UsersDTO.class);
    }
}
