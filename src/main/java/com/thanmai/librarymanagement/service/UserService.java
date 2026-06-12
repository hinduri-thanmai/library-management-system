package com.thanmai.librarymanagement.service;

import com.thanmai.librarymanagement.dto.LoginRequestDTO;
import com.thanmai.librarymanagement.dto.RegisterRequestDTO;
import com.thanmai.librarymanagement.entity.User;

public interface UserService {

    User registerUser(RegisterRequestDTO registerRequestDTO);

    String loginUser(LoginRequestDTO loginRequestDTO);
}