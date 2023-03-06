package com.investec.kata.controller;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class TestUtils {

    public static String getClientJson() throws IOException {
        return new String(Files.readAllBytes(Paths.get(new ClassPathResource("client.json").getURI())));
    }
}
