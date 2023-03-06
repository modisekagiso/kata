package com.investec.kata.testmodel;

import com.investec.kata.model.Client;

public class ClientBuilder {

    private String firstName = "first";
    private String lastName = "last";
    private String idNumber = "0731234567";
    private String mobileNumber = "9512221793081";
    private String physicalAddress = "123 street";

    public Client build() {
        return new Client(firstName, lastName, idNumber, mobileNumber, physicalAddress);
    }

    public static ClientBuilder aClient() {
        return new ClientBuilder();
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
