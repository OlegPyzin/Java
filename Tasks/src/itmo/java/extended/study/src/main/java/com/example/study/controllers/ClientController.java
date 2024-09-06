package com.example.study.controllers;

import com.example.study.model.dto.request.ClientInfoRequest;
import com.example.study.model.dto.response.ClientInfoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

//    @GetMapping
//    public String answerPlace() {
//        return "You are in the Client zone.";
//    }
    @PostMapping
    public ClientInfoResponse createClient(@RequestBody ClientInfoRequest request) {
        return new ClientInfoResponse();
    }

    @GetMapping("/{id}")
    public ClientInfoResponse getClient(@PathVariable Long id) {
        return new ClientInfoResponse();
    }

    @PutMapping("/{id}")
    public ClientInfoResponse updateClient(@PathVariable Long id, @RequestBody ClientInfoRequest request) {
        return new ClientInfoResponse();
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {

    }

    @GetMapping("/all")
    public List<ClientInfoResponse> getAllClient() {
        return Collections.singletonList(new ClientInfoResponse());
    }

}
