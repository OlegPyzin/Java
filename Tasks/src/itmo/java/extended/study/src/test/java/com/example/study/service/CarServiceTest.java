package com.example.study.service;

import com.example.study.exceptions.CustomException;
import com.example.study.model.db.entity.Car;
import com.example.study.model.db.entity.Client;
import com.example.study.model.db.repository.CarRepository;
import com.example.study.model.dto.request.CarInfoRequest;
import com.example.study.model.dto.request.CarToClientRequest;
import com.example.study.model.dto.response.CarInfoResponse;
import com.example.study.model.enums.CarStatus;
import com.example.study.model.enums.ClientStatus;
import com.example.study.model.enums.Color;
import com.example.study.model.enums.Vendor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.*;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
    @InjectMocks
    private CarService carService;

    @Mock
    private ClientService clientService;

    @Mock
    private CarRepository carRepository;

    @Spy
    private ObjectMapper mapper;


    @Test
    public void addCars() {
        CarInfoRequest request = new CarInfoRequest();

        Car car = new Car();
        car.setId(1L);

        when(carRepository.save(any(Car.class))).thenReturn(car);

        CarInfoResponse result = carService.addCars(request);

        assertEquals(car.getId(), result.getId());
    }

    @Test
    public void getCars() {
        Car car = new Car();
        car.setId(1L);

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));
        CarInfoResponse result = carService.getCars(car.getId());

        assertEquals(car.getId(), result.getId());
    }

    @Test(expected = CustomException.class)
    public void getCarsBadId() {
        Car car = new Car();
        car.setId(1L);

        CarInfoResponse result = carService.getCars(car.getId());

        assertEquals(car.getId(), result.getId());
    }

    @Test
    public void updateCar() {
        CarInfoRequest request = new CarInfoRequest();

        request.setColor(Color.GREEN);
        request.setVendor(Vendor.TOYOTA);
        request.setModelName("Test");
        request.setWeight(1000.0f);
        request.setDateMade(new Date());
        request.setDateSold(new Date());
        request.setPrice(BigDecimal.valueOf(3500000));
        request.setRegNumber("test");
        request.setModelVIN("TEST123456789");

        Car car = new Car();
        car.setId(1L);

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));

        //when(clientRepository.save(any(Client.class))).thenReturn(client);
        when(carRepository.save(any(Car.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        CarInfoResponse result = carService.updateCar(car.getId(), request);

        assertEquals(car.getId(), result.getId());
    }

    @Test
    public void updateCarDbField() {
        Car car = new Car();
        CarInfoRequest request = new CarInfoRequest();

        car.setColor(Color.GREEN);
        car.setVendor(Vendor.TOYOTA);
        car.setModelName("Test");
        car.setWeight(1000.0f);
        car.setDateMade(new Date());
        car.setDateSold(new Date());
        car.setPrice(BigDecimal.valueOf(3500000));
        car.setRegNumber("test");
        car.setModelVIN("TEST123456789");

        car.setId(1L);

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));

        //when(clientRepository.save(any(Client.class))).thenReturn(client);
        when(carRepository.save(any(Car.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        CarInfoResponse result = carService.updateCar(car.getId(), request);

        assertEquals(car.getId(), result.getId());
    }

    @Test(expected = CustomException.class)
    public void updateCar_IfFinished() {
        CarInfoRequest request = new CarInfoRequest();

        Car car = new Car();
        car.setId(1L);
        car.setStatus(CarStatus.FINISHED);

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));

        // Закоментированы строки 155,156, поскольку при выполнении всех тестов
        // возникала ошибка:
        // org.mockito.exceptions.misusing.UnnecessaryStubbingException:
        // Unnecessary stubbings detected in test class: CarServiceTest
        // Clean & maintainable test code requires zero unnecessary code.
        // Following stubbings are unnecessary (click to navigate to relevant line of code):
        //  1. -> at com.example.study.service.CarServiceTest.updateCar_IfFinished(CarServiceTest.java:151)
        // Please remove unnecessary stubbings or use 'lenient' strictness. More info: javadoc for UnnecessaryStubbingException class.
        // Но при запуске данного теста индивидуально описанной выше ошибки не было
        //when(carRepository.save(any(Car.class)))
        //        .thenAnswer(i -> i.getArguments()[0]);

        carService.updateCar(car.getId(), request);
    }

    @Test
    public void deleteCar() {
        Car car = new Car();
        car.setId(1L);

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));
        //    when(clientRepository.save(any(Client.class))).thenReturn(client);

        carService.deleteCar(car.getId());

        verify(carRepository, times(1)).save(any(Car.class));
        assertEquals(CarStatus.FINISHED, car.getStatus());
    }

    @Test(expected = CustomException.class)
    public void deleteCar_IfFinished() {
        Car car = new Car();
        car.setId(1L);
        car.setStatus(CarStatus.FINISHED);

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));

        carService.deleteCar(car.getId());
    }

    @Test
    public void getAllCars() {
        List<Car> cars = List.of(new Car(), new Car(), new Car(), new Car());

        when(carRepository.findAll()).thenReturn(cars);

        List<CarInfoResponse> result = carService.getAllCars();

        assertEquals(cars.size(), result.size());
    }

    @Test
    public void addCar2Client() {
        Car car = new Car();
        car.setId(1L);

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));

        Client client = new Client();
        client.setId(1L);
        client.setCars(new ArrayList<>());


        when(clientService.getClientFromDB(client.getId())).thenReturn(client);
        when(clientService.updateClientData(any(Client.class))).thenReturn(client);


        CarToClientRequest request = CarToClientRequest.builder()
                .clientId(client.getId())
                .build();

        carService.addCar2Client(car.getId(), request);

        verify(carRepository, times(1)).save(any(Car.class));
        assertEquals(client.getId(), car.getClient().getId());
    }

    @Test(expected = CustomException.class)
    public void addCar2Client_IfFinished() {
        Car car = new Car();
        car.setId(1L);
        car.setStatus(CarStatus.FINISHED);

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));

        CarToClientRequest request = new CarToClientRequest();

        carService.addCar2Client(1L, request);
    }

    @Test(expected = CustomException.class)
    public void addCar2Client_IfDeleted() {
        Car car = new Car();
        car.setId(1L);

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));

        Client client = new Client();
        client.setId(1L);
        client.setStatus(ClientStatus.DELETED);
        client.setCars(new ArrayList<>());


        when(clientService.getClientFromDB(client.getId())).thenReturn(client);


        CarToClientRequest request = CarToClientRequest.builder()
                .clientId(client.getId())
                .build();

        carService.addCar2Client(car.getId(), request);
    }


    @Test
    public void getAllCarsByPages() {
        Integer page = 0;
        Integer perPage = 5;
        String sort = null;
        Sort.Direction direction = null;
        String filter ="";

        Pageable pageRequest = PageRequest.of(page, perPage);

        Page<Car> list = new PageImpl<>(Collections.emptyList());

        when(carRepository.findAllByStatusNot(pageRequest, CarStatus.FINISHED)).thenReturn(list);

        Page<CarInfoResponse> result = carService.getAllCarsByPages(page, perPage, sort, direction, filter);

        assertEquals(list.getTotalElements(), result.getTotalElements());
    }
}