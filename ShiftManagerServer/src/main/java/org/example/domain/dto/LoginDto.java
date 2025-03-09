package org.example.domain.dto;

import jakarta.validation.constraints.NotEmpty;

public class LoginDto {

    @NotEmpty
    public String username;
    @NotEmpty
    public String password;
}
