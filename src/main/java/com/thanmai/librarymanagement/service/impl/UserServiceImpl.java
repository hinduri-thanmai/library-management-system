package com.thanmai.librarymanagement.service.impl;

import com.thanmai.librarymanagement.dto.LoginRequestDTO;
import com.thanmai.librarymanagement.dto.RegisterRequestDTO;
import com.thanmai.librarymanagement.entity.User;
import com.thanmai.librarymanagement.repository.UserRepository;
import com.thanmai.librarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(RegisterRequestDTO registerRequestDTO) {

        if (userRepository.existsByEmail(registerRequestDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(registerRequestDTO.getName());
        user.setEmail(registerRequestDTO.getEmail());
        user.setPassword(registerRequestDTO.getPassword());
        user.setRole(registerRequestDTO.getRole());
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public String loginUser(LoginRequestDTO loginRequestDTO) {

        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(loginRequestDTO.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login Successful";
    }
}