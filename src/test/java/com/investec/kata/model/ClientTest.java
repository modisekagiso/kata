package com.investec.kata.model;

import com.investec.kata.exceptions.ClientValidationException;
import org.junit.jupiter.api.Test;

import static com.investec.kata.testmodel.ClientBuilder.aClient;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ClientTest {

    @Test
    void createClientWhenNoFirstNameShouldThrowValidationException() {
        assertThrows(ClientValidationException.class, () -> aClient().withFirstName(null).build(),
                "First name is required");
    }

    @Test
    void createClientWhenEmptyFirstNameShouldThrowValidationException() {
        assertThrows(ClientValidationException.class, () -> aClient().withFirstName("").build(),
                "First name is required");
    }

    @Test
    void createClientWhenNoLastNameShouldThrowValidationException() {
        assertThrows(ClientValidationException.class, () -> aClient().withLastName(null).build(),
                "Last name is required");
    }

    @Test
    void createClientWhenEmptyLastNameShouldThrowValidationException() {
        assertThrows(ClientValidationException.class, () -> aClient().withLastName("").build(),
                "Last name is required");
    }

    @Test
    void createClientWhenNoIDNumberShouldThrowValidationException() {
        assertThrows(ClientValidationException.class, () -> aClient().withIdNumber(null).build(),
                "ID Number is required");
    }

    @Test
    void createClientWhenEmptyIDNumberShouldThrowValidationException() {
        assertThrows(ClientValidationException.class, () -> aClient().withIdNumber("").build(),
                "ID Number is required");
    }

    @Test
    void createClientWhenInvalidIDNumberShouldThrowValidationException() {
        assertThrows(ClientValidationException.class, () -> aClient().withIdNumber("9512221793082").build(),
                "ID Number is not valid");
    }
}