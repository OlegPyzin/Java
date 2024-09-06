package com.example.study.controllers;

import com.example.study.model.dto.request.*;
import com.example.study.model.dto.response.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

//    @GetMapping
//    public String answerPlace() {
//        return "You are in the Cars zone.";
//    }
    @PostMapping
    public CarInfoResponse addCar(@RequestBody CarInfoRequest request) {
        return new CarInfoResponse();
    }

    @GetMapping("/{modelVIN}")
    public CarInfoResponse getCar(@PathVariable String modelVIN) {
        return new CarInfoResponse();
    }

    @PutMapping("/{modelVIN}")
    public CarInfoResponse updateCar(@PathVariable String modelVIN, @RequestBody CarInfoRequest request) {
        return new CarInfoResponse();
    }

    @DeleteMapping("/{modelVIN}")
    public void deleteClient(@PathVariable String modelVIN) {

    }

    @GetMapping("/all")
    public List<CarInfoResponse> getAllCar() {
        return Collections.singletonList(new CarInfoResponse());
    }

}
