package com.investec.kata.testmodel;

import com.investec.kata.model.Client;

public class ClientBuilder {

    private String id = "9a10a3f4-1bc4-4116-87eb-478b7bcf665f";
    private String firstName = "first";
    private String lastName = "last";
    private String idNumber = "9512221793081";
    private String mobileNumber = "0731234567";
    private String physicalAddress = "123 street";

    public Client build() {
        Client client = new Client(firstName, lastName, idNumber, mobileNumber, physicalAddress);
        client.setId(id);
        return client;
    }

    public static ClientBuilder aClient() {
        return new ClientBuilder();
    }

    public ClientBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ClientBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ClientBuilder withIdNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public ClientBuilder withMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public ClientBuilder withPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
        return this;
    }
}
