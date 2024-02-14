package com.example.manage_backend.domain.vo;

import lombok.Data;

@Data
public class RegisterInfo {
    private String username;
    private String password;
    private String confirmPassword;
    private String address;
}
