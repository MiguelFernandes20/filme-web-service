package com.example.filmewebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filme")
public class filmeController {

    @GetMapping
    public String olamundo(){
        return "Olá Mundo";
    }
}
