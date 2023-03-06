package com.investec.kata.service;

import com.investec.kata.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.investec.kata.testmodel.ClientBuilder.aClient;
import static java.util.Collections.emptyList;
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
        given(clientRepository.findBymobileNumber(anyString())).willReturn(emptyList());
        assertThat(clientService.getClientsByMobileNumber("0731234567")).isEmpty();
    }

    @Test
    void createClientShouldShouldReturnClient() {
        given(clientRepository.save(any())).willReturn(null);
        assertThat(clientService.createClient(aClient().build()).getFirstName()).isEqualTo("first");
    }
}