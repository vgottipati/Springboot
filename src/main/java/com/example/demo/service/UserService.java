package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import java.util.List;


public interface UserService {

        List<UserDTO> getAllUsers();
        UserDTO getUserById(String id);
        UserDTO addUser(UserDTO user);
        void deleteUser(String id);
}
