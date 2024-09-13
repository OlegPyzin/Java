package com.example.study.controllers;

import com.example.study.model.dto.request.*;
import com.example.study.model.dto.response.*;
import com.example.study.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static com.example.study.constants.Constants.*;

@RestController
@RequestMapping(CARS)
@RequiredArgsConstructor
public class CarsController {

//    @GetMapping
//    public String answerPlace() {
//        return "You are in the Cars zone.";
//    }
    private final CarService carService;

    @PostMapping
    public CarInfoResponse addCar(@RequestBody CarInfoRequest request) {
        return carService.addCars(request);
    }

    @GetMapping("/{id}")
    public CarInfoResponse getCar(@PathVariable Long id) {
        return carService.getCars(id);
    }

    @PutMapping("/{id}")
    public CarInfoResponse updateCar(@PathVariable Long id, @RequestBody CarInfoRequest request) {
        return carService.updateCar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/all")
    public List<CarInfoResponse> getAllCar() {
        return carService.getAllCar();
    }

}
