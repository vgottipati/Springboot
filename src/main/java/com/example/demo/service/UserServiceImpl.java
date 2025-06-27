package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {

        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(String id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElse(null);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }



}
