package com.example.study.service;

import com.example.study.model.dto.request.CarInfoRequest;
import com.example.study.model.dto.response.CarInfoResponse;
import com.example.study.model.enums.Color;
import com.example.study.model.enums.Vendor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    public CarInfoResponse addCars(CarInfoRequest request) {
        return CarInfoResponse.builder()
                .modelName(request.getModelName())
                .vendor(request.getVendor())
                .modelVIN(request.getModelVIN())
                .color(request.getColor())
                .dateMade(request.getDateMade())
                .weight(request.getWeight())
                .build();
    }

    public CarInfoResponse getCars(String modelVIN) {
        return CarInfoResponse.builder()
                .modelName("Cotolla")
                .vendor(Vendor.TOYOTA)
                .modelVIN("JSQKA1234567788900")
                .color(Color.GREEN)
                .dateMade(new Date("2021/10/10"))
                .weight(1200.0f)
                .build();
    }

    public CarInfoResponse updateCar(String modelVIN, CarInfoRequest request) {
        return null;
    }

    public void deleteCar(String modelVIN) {
    }

    public List<CarInfoResponse> getAllCar() {
        return Collections.emptyList();
    }
}
