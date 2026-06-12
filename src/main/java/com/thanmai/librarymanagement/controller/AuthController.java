package com.thanmai.librarymanagement.controller;

import com.thanmai.librarymanagement.dto.LoginRequestDTO;
import com.thanmai.librarymanagement.dto.RegisterRequestDTO;
import com.thanmai.librarymanagement.entity.User;
import com.thanmai.librarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return userService.registerUser(registerRequestDTO);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        return userService.loginUser(loginRequestDTO);
    }
}