package com.example.study.controllers;

import com.example.study.model.dto.request.ClientInfoRequest;
import com.example.study.model.dto.response.ClientInfoResponse;
import com.example.study.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.study.constants.Constants.*;

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
    public ClientInfoResponse createClient(@RequestBody ClientInfoRequest request) {
        return clientService.createClient(request);
    }

    @GetMapping("/{id}")
    public ClientInfoResponse getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PutMapping("/{id}")
    public ClientInfoResponse updateClient(@PathVariable Long id, @RequestBody ClientInfoRequest request) {
        return clientService.updateClient(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/all")
    public List<ClientInfoResponse> getAllClient() {
        return clientService.getAllClients();
    }

}
