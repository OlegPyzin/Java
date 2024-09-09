package com.example.study.service;

import com.example.study.model.dto.request.ClientInfoRequest;
import com.example.study.model.dto.response.ClientInfoResponse;
import com.example.study.model.enums.Gender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
    long i=0L;

    public ClientInfoResponse createClient(ClientInfoRequest request) {
        if (!EmailValidator.getInstance().isValid(request.getEmail())) {
            return null;
        }

        return ClientInfoResponse.builder()
                .password(request.getPassword())
                .email(request.getEmail())
                .age(request.getAge())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .phone(request.getPhone())
                .address(request.getAddress())
                .build();
    }

    public ClientInfoResponse getClient(Long id) {
        return ClientInfoResponse.builder()
                .email("test@test.com")
                .age(35)
                .firstName("It's")
                .lastName("me")
                .gender(Gender.MALE)
                .phone("123456789")
                .address("Some place")
                .id(i++)
                .build();
    }

    public ClientInfoResponse updateClient(Long id, ClientInfoRequest request) {
        long i=0L;
        return ClientInfoResponse.builder()
                .password(request.getPassword())
                .email(request.getEmail())
                .age(request.getAge())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .phone(request.getPhone())
                .address(request.getAddress())
                .id(i++)
                .build();
    }

    public void deleteClient(Long id) {
    }

    public List<ClientInfoResponse> getAllClients() {
        return Collections.emptyList();
    }
}
