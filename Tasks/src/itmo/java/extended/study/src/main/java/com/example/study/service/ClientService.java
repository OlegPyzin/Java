package com.example.study.service;

import com.example.study.model.db.entity.Client;
import com.example.study.model.db.repository.ClientRepository;
import com.example.study.model.dto.request.ClientInfoRequest;
import com.example.study.model.dto.response.ClientInfoResponse;
import com.example.study.model.enums.ClientStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
    long i=0L;
    private final ObjectMapper mapper;
    private final ClientRepository clientRepository;

    public ClientInfoResponse createClient(ClientInfoRequest request) {

        if (!EmailValidator.getInstance().isValid(request.getEmail())) {
            return null;
        }

        Client client = mapper.convertValue(request, Client.class);
        client.setAddedAt(LocalDateTime.now());
        client.setStatus(ClientStatus.ADDED);

        Client saved = clientRepository.save(client);

        return mapper.convertValue(saved, ClientInfoResponse.class);

        // Has been used before. To study and for a test
//        return ClientInfoResponse.builder()
//                .password(request.getPassword())
//                .email(request.getEmail())
//                .age(request.getAge())
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .middleName(request.getMiddleName())
//                .gender(request.getGender())
//                .phone(request.getPhone())
//                .address(request.getAddress())
//                .build();
    }

    private Client getClientFromDB(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public ClientInfoResponse getClient(Long id) {

        Client client = getClientFromDB(id);
        if (client == null) {
            client = new Client();
        }
        return mapper.convertValue(client, ClientInfoResponse.class);
        // Has been used before. To study and for a test
//        return ClientInfoResponse.builder()
//                .email("test@test.com")
//                .age(35)
//                .firstName("It's")
//                .lastName("me")
//                .gender(Gender.MALE)
//                .phone("123456789")
//                .address("Some place")
//                .id(i++)
//                .build();
    }

    public ClientInfoResponse updateClient(Long id, ClientInfoRequest request) {

        if (!EmailValidator.getInstance().isValid(request.getEmail())) {
            return null;
        }
        Client client = getClientFromDB(id);

        if (client != null) {
            client.setEmail(request.getEmail());
            client.setFirstName(request.getFirstName() == null? client.getFirstName(): request.getFirstName());
            client.setLastName(request.getLastName() == null? client.getLastName(): request.getLastName());
            client.setMiddleName(request.getMiddleName() == null? client.getMiddleName(): request.getMiddleName());
            client.setAge(request.getAge() == null ? client.getAge() : request.getAge());
            client.setGender(request.getGender() == null ? client.getGender() : request.getGender());
            client.setAddress(request.getAddress() == null? client.getAddress(): request.getAddress());
            client.setPhone(request.getPhone() == null? client.getPhone(): request.getPhone());
            client.setPassword(request.getPassword() == null? client.getPassword(): request.getPassword());

            client.setUpdatedAt(LocalDateTime.now());
            client.setStatus(ClientStatus.UPDATED);
        }

        Client saved = clientRepository.save(client);

        return mapper.convertValue(saved, ClientInfoResponse.class);

        // Has been used before. To study and for a test
//        return ClientInfoResponse.builder()
//                .password(request.getPassword())
//                .email(request.getEmail())
//                .age(request.getAge())
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .gender(request.getGender())
//                .phone(request.getPhone())
//                .address(request.getAddress())
//                .id(i++)
//                .build();
    }

    public void deleteClient(Long id) {
        Client client = getClientFromDB(id);

        if (client != null) {
            client.setUpdatedAt(LocalDateTime.now());
            client.setStatus(ClientStatus.DELETED);
            clientRepository.save(client);
        }
    }

    public List<ClientInfoResponse> getAllClients() {
        return clientRepository.findAll().stream()
                .map(client -> mapper.convertValue(client, ClientInfoResponse.class))
                .collect(Collectors.toList());
    }
}
