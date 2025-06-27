package com.example.demo.controller;


import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping(value="", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserDTO getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

}
