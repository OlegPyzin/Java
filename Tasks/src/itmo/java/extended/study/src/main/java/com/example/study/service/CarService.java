package com.example.study.service;

import com.example.study.model.db.entity.Car;
import com.example.study.model.db.entity.Client;
import com.example.study.model.db.repository.CarRepository;
import com.example.study.model.dto.request.CarInfoRequest;
import com.example.study.model.dto.response.CarInfoResponse;
import com.example.study.model.enums.CarStatus;
import com.example.study.model.enums.ClientStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ObjectMapper mapper;

    public CarInfoResponse addCars(CarInfoRequest request) {

        Car car = mapper.convertValue(request, Car.class);
        car.setAddedAt(LocalDateTime.now());
        car.setStatus(CarStatus.SHIPPED);
        Car saved = carRepository.save(car);

        return mapper.convertValue(saved, CarInfoResponse.class);
    }

    private Car getCarFromDB(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public CarInfoResponse getCars(Long id) {
        Car car = getCarFromDB(id);
        if (car == null) {
            car = new Car();
        }
        return mapper.convertValue(car, CarInfoResponse.class);
    }

    public CarInfoResponse updateCar(Long id, CarInfoRequest request) {
        Car car = getCarFromDB(id);

        if (car != null) {
            car.setModelName(request.getModelName() == null ? car.getModelName() : request.getModelName());
            car.setModelVIN(request.getModelVIN() == null ? car.getModelVIN() : request.getModelVIN());
            car.setWeight(request.getWeight() == null ? car.getWeight() : request.getWeight());
            car.setColor(request.getColor() == null ? car.getColor() : request.getColor());
            car.setDateMade(request.getDateMade() == null ? car.getDateMade() : request.getDateMade());
            car.setDateSold(request.getDateSold() == null ? car.getDateSold() : request.getDateSold());
            car.setVendor(request.getVendor() == null ? car.getVendor() : request.getVendor());
            car.setPrice(request.getPrice() == null ? car.getPrice() : request.getPrice());
            car.setRegNumber(request.getRegNumber() == null ? car.getRegNumber() : request.getRegNumber());
            car.setUpdatedAt(LocalDateTime.now());
            car.setStatus(CarStatus.UPDATED);
        }
        Car saved = carRepository.save(car);

        return mapper.convertValue(saved, CarInfoResponse.class);
    }

    public void deleteCar(Long id) {
        Car car = getCarFromDB(id);

        if (car != null) {
            car.setUpdatedAt(LocalDateTime.now());
            car.setStatus(CarStatus.FINISHED);
            carRepository.save(car);
        }
    }

    public List<CarInfoResponse> getAllCar() {
        return carRepository.findAll().stream()
                .map(car -> mapper.convertValue(car, CarInfoResponse.class))
                .collect(Collectors.toList());
    }
}
