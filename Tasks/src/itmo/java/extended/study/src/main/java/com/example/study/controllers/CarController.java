package com.example.study.controllers;

import com.example.study.model.dto.request.*;
import com.example.study.model.dto.response.*;
import com.example.study.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.study.constants.Constants.*;

@Tag(name = "Работа с автомобилями")
@RestController
@RequestMapping(CARS)
@RequiredArgsConstructor
public class CarController {

//    @GetMapping
//    public String answerPlace() {
//        return "You are in the Cars zone.";
//    }
    private final CarService carService;

    @PostMapping
    @Operation(summary = "Добавить автомобиль")
    public CarInfoResponse addCar(@RequestBody CarInfoRequest request) {
        return carService.addCars(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Информация об автомобиле")
    public CarInfoResponse getCar(@PathVariable Long id) {
        return carService.getCars(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить данные автомобиля")
    public CarInfoResponse updateCar(@PathVariable Long id, @RequestBody CarInfoRequest request) {
        return carService.updateCar(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Остановить обслуживание автомобиля")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Список автомобилей")
    public List<CarInfoResponse> getAllCar() {
        return carService.getAllCar();
    }

    @PostMapping("/{id}/addclient")
    @Operation(summary = "Добавить автомобиль клиенту")
    public void addCar2Client(@PathVariable Long id, @RequestBody @Valid CarToClientRequest request) {
        carService.addCar2Client(id, request);
    }

}
