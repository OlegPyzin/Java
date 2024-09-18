package com.example.study.controllers;

import com.example.study.model.dto.request.ClientInfoRequest;
import com.example.study.model.dto.response.CarInfoResponse;
import com.example.study.model.dto.response.ClientInfoResponse;
import com.example.study.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.study.constants.Constants.*;

@Tag(name = "Работа с клиентами")
@RestController
@RequestMapping(CLIENTS)
@RequiredArgsConstructor
public class ClientController {

//    @GetMapping
//    public String answerPlace() {
//        return "You are in the Client zone.";
//    }

    private final ClientService clientService;

    @PostMapping
    @Operation(summary = "Добавить клиента")
    public ClientInfoResponse createClient(@RequestBody ClientInfoRequest request) {
        return clientService.createClient(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Информация о клиенте")
    public ClientInfoResponse getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить данные клиента")
    public ClientInfoResponse updateClient(@PathVariable Long id, @RequestBody ClientInfoRequest request) {
        return clientService.updateClient(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Остановить обслуживание клиента")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Список клиентов")
    public List<ClientInfoResponse> getAllClient() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}/listcars")
    @Operation(summary = "Информация об автомобилях клиента")
    public List<CarInfoResponse> getClientCars(@PathVariable Long id) {
        return clientService.getClientCars(id);
    }
}
