package com.thanmai.librarymanagement.dto;

import com.thanmai.librarymanagement.enums.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    private String name;
    private String email;
    private String password;
    private Role role;
}