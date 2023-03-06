package com.investec.kata.repository;

import com.investec.kata.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    List<Client> findByFirstName(String firstName);

    List<Client> findByIdNumber(String idNumber);

    List<Client> findBymobileNumber(String mobileNumber);
}
