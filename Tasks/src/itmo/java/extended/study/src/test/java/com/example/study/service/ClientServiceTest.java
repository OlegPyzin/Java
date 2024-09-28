package com.example.study.service;

import com.example.study.exceptions.CustomException;
import com.example.study.model.db.entity.Car;
import com.example.study.model.db.entity.Client;
import com.example.study.model.db.repository.ClientRepository;
import com.example.study.model.dto.request.ClientInfoRequest;
import com.example.study.model.dto.response.CarInfoResponse;
import com.example.study.model.dto.response.ClientInfoResponse;
import com.example.study.model.enums.ClientStatus;
import com.example.study.model.enums.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.*;

import java.util.*;


import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Spy
    private ObjectMapper mapper;


    @Test
    public void createClient() {

        ClientInfoRequest request = new ClientInfoRequest();
        request.setEmail("test@test.com");

        Client client = new Client();
        client.setId(1L);

        when(clientRepository.save(any(Client.class))).thenReturn(client);

        ClientInfoResponse result = clientService.createClient(request);

        assertEquals(client.getId(), result.getId());
    }

    @Test(expected = CustomException.class)
    public void createClient_badEmail() {
        ClientInfoRequest request = new ClientInfoRequest();
        request.setEmail("bad-email#test.com");

        clientService.createClient(request);
    }

    @Test(expected = CustomException.class)
    public void createClient_duplicateEmail() {

        ClientInfoRequest request = new ClientInfoRequest();
        request.setEmail("test@test.com");

        Client client = new Client();
        client.setId(1L);

       when(clientRepository.findByEmailIgnoreCase(anyString())).thenReturn(Optional.of(client));

       clientService.createClient(request);
    }

    @Test
    public void getClient() {
        Long id = 1L;

        Client client = new Client();
        client.setId(id);

        when(clientRepository.findById(id)).thenReturn(Optional.of(client));
        ClientInfoResponse result = clientService.getClient(id);

        assertEquals(client.getId(), result.getId());
    }


    @Test(expected = CustomException.class)
    public void getClient_badId() {
        Long id = 1L;

        Client client = new Client();
        client.setId(id);

        ClientInfoResponse result = clientService.getClient(id);

        assertEquals(client.getId(), result.getId());
    }

    // ниже строка была добавлена автоматически при нажатии command+Shift+T
    // при этом не была добавлена строка
    // import org.junit.Test;
    //@org.junit.Test
    @Test
    public void updateClient() {

        ClientInfoRequest request = new ClientInfoRequest();
        request.setEmail("test@test.com");
        request.setFirstName("Test");
        request.setLastName("Test");
        request.setMiddleName("Test");
        request.setAddress("Test test test");
        request.setAge(30);
        request.setGender(Gender.MALE);
        request.setPhone("123456789");
        request.setPassword("qwerty");

        Client client = new Client();
        client.setId(1L);

        Long id = 1L;

        when(clientRepository.findById(id)).thenReturn(Optional.of(client));

        //when(clientRepository.save(any(Client.class))).thenReturn(client);
        when(clientRepository.save(any(Client.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        ClientInfoResponse result = clientService.updateClient(id, request);

        assertEquals(client.getId(), result.getId());
    }

    @Test
    public void updateClient_fillDbFields() {

        ClientInfoRequest request = new ClientInfoRequest();
        request.setEmail("test@test.com");

        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Test");
        client.setLastName("Test");
        client.setMiddleName("Test");
        client.setAddress("Test test test");
        client.setAge(30);
        client.setGender(Gender.MALE);
        client.setPhone("123456789");
        client.setPassword("qwerty");

        Long id = 1L;

        when(clientRepository.findById(id)).thenReturn(Optional.of(client));

        //when(clientRepository.save(any(Client.class))).thenReturn(client);
        when(clientRepository.save(any(Client.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        ClientInfoResponse result = clientService.updateClient(id, request);

        assertEquals(client.getId(), result.getId());
    }


    @Test(expected = CustomException.class)
    public void updateClient_ifDeleted() {

        ClientInfoRequest request = new ClientInfoRequest();
        request.setEmail("test@test.com");

        Client client = new Client();
        client.setId(1L);
        client.setStatus(ClientStatus.DELETED);

        Long id = 1L;

        when(clientRepository.findById(id)).thenReturn(Optional.of(client));
        //when(clientRepository.save(any(Client.class))).thenReturn(client);

        clientService.updateClient(id, request);
    }


    @org.junit.Test
    public void deleteClient() {
        Client client = new Client();
        client.setId(1L);

        when(clientRepository.findById(client.getId())).thenReturn(Optional.of(client));
    //    when(clientRepository.save(any(Client.class))).thenReturn(client);

        clientService.deleteClient(client.getId());

        verify(clientRepository, times(1)).save(any(Client.class));
        assertEquals(ClientStatus.DELETED, client.getStatus());
    }

    @org.junit.Test(expected = CustomException.class)
    public void deleteClient_ifDeleted() {
        Client client = new Client();
        client.setId(1L);
        client.setStatus(ClientStatus.DELETED);

        when(clientRepository.findById(client.getId())).thenReturn(Optional.of(client));
    //    when(clientRepository.save(any(Client.class))).thenReturn(client);

        clientService.deleteClient(client.getId());
    }


    @org.junit.Test
    public void getAllClients() {
        List<Client> clients = List.of(new Client(), new Client());

        when(clientRepository.findAll()).thenReturn(clients);

        List<ClientInfoResponse> list = clientService.getAllClients();
        
        assertEquals(clients.size(), list.size());
    }

    @org.junit.Test
    public void updateClientData() {
        Client client = new Client();
        client.setId(1L);
        client.setStatus(ClientStatus.ADDED);

        //when(clientRepository.save(any(Client.class))).thenReturn(client);
        when(clientRepository.save(any(Client.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        Client result = clientService.updateClientData(client);

        assertEquals(client.getId(), result.getId());
    }

    @org.junit.Test
    public void getClientCars() {
        Long id = 1L;
        List<Car> cars = List.of(new Car(), new Car());
        Client client = new Client();
        client.setId(1L);
        client.setCars(cars);

        when(clientRepository.findById(id)).thenReturn(Optional.of(client));

        List<CarInfoResponse> result = clientService.getClientCars(id);

        assertEquals(cars.size(), result.size());
    }

    @org.junit.Test
    public void getAllClientsByPages() {
        Integer page = 0;
        Integer perPage = 5;
        String sort = null;
        Sort.Direction direction = null;
        String filter ="";

        Pageable pageRequest = PageRequest.of(page,perPage);
        Page<Client> list = new PageImpl<>(Collections.emptyList());

        when(clientRepository.findAllByStatusNot(pageRequest, ClientStatus.DELETED)).thenReturn(list);

        Page<ClientInfoResponse> result = clientService.getAllClientsByPages(page, perPage, sort, direction, filter);

        assertEquals(list.getTotalElements(), result.getTotalElements());
    }
}