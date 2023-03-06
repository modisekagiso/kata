package com.investec.kata.model;

import com.investec.kata.exceptions.ClientValidationException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String idNumber;
    @Column(unique = true)
    private String mobileNumber;
    @Column
    private String physicalAddress;

    public Client(String firstName, String lastName, String idNumber, String mobileNumber, String physicalAddress) {
        if (firstName == null || firstName.isEmpty())
            throw new ClientValidationException("First name is required");
        this.firstName = firstName;
        if (lastName == null || lastName.isEmpty())
            throw new ClientValidationException("Last name is required");
        this.lastName = lastName;
        if (idNumber == null || idNumber.isEmpty())
            throw new ClientValidationException("ID Number is required");
        if (!LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(idNumber.trim()))
            throw new ClientValidationException("ID Number is not valid");
        this.idNumber = idNumber;
        this.mobileNumber = mobileNumber;
        this.physicalAddress = physicalAddress;
    }
}
