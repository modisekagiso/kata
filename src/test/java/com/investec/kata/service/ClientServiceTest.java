package com.investec.kata.service;

import com.investec.kata.model.Client;
import com.investec.kata.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.investec.kata.testmodel.ClientBuilder.aClient;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ClientService.class)
class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    void getClientsByFirstNameShouldReturnClient() {
        given(clientRepository.findByFirstName(anyString())).willReturn(emptyList());
        assertThat(clientService.getClientsByFirstName("firstName")).isEmpty();
    }

    @Test
    void getClientsShouldReturnClients() {
        given(clientRepository.findAll()).willReturn(emptyList());
        assertThat(clientService.getClients()).isEmpty();
    }

    @Test
    void getClientsByIDNumberShouldReturnClient() {
        given(clientRepository.findByIdNumber(anyString())).willReturn(emptyList());
        assertThat(clientService.getClientsByIdNumber("9512221793081")).isEmpty();
    }

    @Test
    void getClientsByMobileNumberShouldReturnClient() {
        given(clientRepository.findByMobileNumber(anyString())).willReturn(emptyList());
        assertThat(clientService.getClientsByMobileNumber("0731234567")).isEmpty();
    }

    @Test
    void createClientShouldShouldReturnClient() {
        Client client = aClient().build();
        given(clientRepository.save(any())).willReturn(client);
        assertThat(clientService.createClient(client).getFirstName()).isEqualTo("first");
    }

    @Test
    void updateClientShouldShouldReturnClient() {
        Client newClient = aClient().withId(null).withFirstName("name").build();
        Client existingClient = aClient().build();
        given(clientRepository.findById(anyString())).willReturn(of(existingClient));
        given(clientRepository.save(any())).willReturn(newClient);
        assertThat(clientService.updateClient(existingClient.getId(), newClient).getFirstName()).isEqualTo("name");
    }

    @Test
    void updateClientWhenNotFoundShouldShouldReturnNull() {
        Client newClient = aClient().withId(null).withFirstName("name").build();
        given(clientRepository.findById(anyString())).willReturn(empty());
        given(clientRepository.save(any())).willReturn(newClient);
        assertThat(clientService.updateClient("9a10a3f4-1bc4-4116-87eb-478b7bcf665f", newClient)).isNull();
    }
}