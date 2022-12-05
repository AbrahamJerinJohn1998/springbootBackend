package com.nest.studentapp_new_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class studentcontroller {
    @GetMapping("/")
    public String Homepage()
    {
        return "Welcome to home page";
    }
    @GetMapping("/contact")
    public String Contact()
    {
        return "Welcome to contact page";
    }
    @GetMapping("/gallery")
    public String gallery()
            {
              return "Gallery";
            }
}
