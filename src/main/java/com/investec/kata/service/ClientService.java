package com.investec.kata.service;

import com.investec.kata.model.Client;
import com.investec.kata.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getClientsByFirstName(String firstName) {
        return clientRepository.findByFirstName(firstName);
    }

    public List<Client> getClientsByIdNumber(String idNumber) {
        return clientRepository.findByIdNumber(idNumber);
    }

    public List<Client> getClientsByMobileNumber(String mobileNumber) {
        return clientRepository.findByMobileNumber(mobileNumber);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(String id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty())
            return null;
        client.setId(optionalClient.get().getId());
        return clientRepository.save(client);
    }
}
