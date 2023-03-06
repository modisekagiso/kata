package com.investec.kata.controller;

import com.investec.kata.model.Client;
import com.investec.kata.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getClients(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "idNumber", required = false) String idNumber,
            @RequestParam(value = "mobileNumber", required = false) String mobileNumber
    ) {
        List<Client> client;
        if (firstName != null)
            client = clientService.getClientsByFirstName(firstName);
        else if (idNumber != null)
            client = clientService.getClientsByIdNumber(idNumber);
        else if (mobileNumber != null)
            client = clientService.getClientsByMobileNumber(mobileNumber);
        else
            client = clientService.getClients();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClients(@RequestBody Client client) {
        Client persistedClient = clientService.createClient(client);
        if (persistedClient == null)
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
}
