package com.example.manage_backend.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
//    @JsonIgnore
    private String password;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date create_time;

}
