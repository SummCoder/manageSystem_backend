package com.example.manage_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ManageBackendApplication {


    public static void main(String[] args) {
        SpringApplication.run(ManageBackendApplication.class, args);
    }

}
