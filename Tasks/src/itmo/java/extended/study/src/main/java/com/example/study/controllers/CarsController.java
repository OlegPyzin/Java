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

    @GetMapping("/{modelVIN}")
    public CarInfoResponse getCar(@PathVariable String modelVIN) {
        return carService.getCars(modelVIN);
    }

    @PutMapping("/{modelVIN}")
    public CarInfoResponse updateCar(@PathVariable String modelVIN, @RequestBody CarInfoRequest request) {
        return carService.updateCar(modelVIN, request);
    }

    @DeleteMapping("/{modelVIN}")
    public void deleteCar(@PathVariable String modelVIN) {
        carService.deleteCar(modelVIN);
    }

    @GetMapping("/all")
    public List<CarInfoResponse> getAllCar() {
        return carService.getAllCar();
    }

}
