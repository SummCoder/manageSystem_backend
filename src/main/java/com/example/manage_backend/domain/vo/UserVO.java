package com.example.manage_backend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserVO {
    private String username;
    private String token;
}
