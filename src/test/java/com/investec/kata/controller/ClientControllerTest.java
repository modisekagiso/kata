package com.investec.kata.controller;


import com.investec.kata.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.investec.kata.controller.TestUtils.getClientJson;
import static com.investec.kata.testmodel.ClientBuilder.aClient;
import static java.util.Collections.emptyList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    void getClientsShouldReturnClients() throws Exception {
        given(clientService.getClientsByFirstName(anyString())).willReturn(emptyList());
        mockMvc.perform(get("/clients")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getClientByFirstNameShouldReturnClient() throws Exception {
        given(clientService.getClientsByFirstName(anyString())).willReturn(emptyList());
        mockMvc.perform(get("/clients?firstName=firstName")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getClientByIdNumberShouldReturnClient() throws Exception {
        given(clientService.getClientsByIdNumber(anyString())).willReturn(emptyList());
        mockMvc.perform(get("/clients?idNumber=9512221793081")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getClientByMobileNumberShouldReturnClient() throws Exception {
        given(clientService.getClientsByMobileNumber(anyString())).willReturn(emptyList());
        mockMvc.perform(get("/clients?mobileNumber=0731234567")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createClientShouldReturnClient() throws Exception {
        given(clientService.createClient(any())).willReturn(aClient().build());
        mockMvc.perform(post("/clients")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getClientJson()))
                .andExpect(status().isCreated());
    }

    @Test
    void createClientWhenNotCreatedShouldReturnUnprocessableEntity() throws Exception {
        given(clientService.createClient(any())).willReturn(null);
        mockMvc.perform(post("/clients")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getClientJson()))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void updateClientShouldReturnClient() throws Exception {
        given(clientService.updateClient(anyString(), any())).willReturn(aClient().build());
        mockMvc.perform(put("/clients/9a10a3f4-1bc4-4116-87eb-478b7bcf665f")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getClientJson()))
                .andExpect(status().isAccepted());
    }

    @Test
    void updateClientWhenNotUpdatedShouldReturnNotAcceptable() throws Exception {
        given(clientService.updateClient(anyString(), any())).willReturn(null);
        mockMvc.perform(put("/clients/9a10a3f4-1bc4-4116-87eb-478b7bcf665f")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getClientJson()))
                .andExpect(status().isNotAcceptable());
    }
}