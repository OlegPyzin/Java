package com.example.study.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    @GetMapping
    public String answerPlace() {
        return "You are in the Cars zone.";
    }

}
