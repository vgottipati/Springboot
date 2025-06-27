package com.example.demo.mapper;


import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
