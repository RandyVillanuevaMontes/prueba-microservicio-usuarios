package com.examen.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {

    public List<String> getData() throws IOException {

        InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("data/data.txt");
        
        //System.out.println("ESTE ES MI MENSAJE " + getClass().getClassLoader().getResource("data/data.txt"));

        if (input == null) {
            throw new RuntimeException("No se encontró el archivo data.txt en resources");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        return reader.lines().collect(Collectors.toList());
    }
}