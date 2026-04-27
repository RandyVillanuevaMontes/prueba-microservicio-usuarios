package com.examen.service;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.repository.DataRepository;

@Service
public class DataService {

    @Autowired
    private DataRepository repository;

    //public List<Map<String, Object>> getDatos() throws IOException {

        //List<String> lines = repository.getData();
    public List<Map<String, Object>> getDatos(String loginTime) throws IOException {

        List<String> lines = repository.getData();

        final LocalDateTime finFrontend =
                (loginTime != null && !loginTime.isEmpty())
                        ? Instant.parse(loginTime)
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime()
                        : null;

        return lines.stream().map(line -> {

            String[] data = line.split("\\|");

            Map<String, Object> usuario = new HashMap<>();

            usuario.put("id", data[0]);
            usuario.put("clave", data[1]);
            usuario.put("tipo", data[2]);
            usuario.put("nombre", data[3]);
            usuario.put("username", data[4]);
            usuario.put("apellidoP", data[5]);
            usuario.put("apellidoM", data[6]);
            usuario.put("password", data[7]);
            usuario.put("estatus", data[10]);

            LocalDateTime inicio = LocalDateTime.parse(data[8]);
            LocalDateTime fin;

            if ("ACTIVO".equalsIgnoreCase(data[10])) {
                fin = (finFrontend != null) ? finFrontend : LocalDateTime.now();
            } else {
                fin = LocalDateTime.parse(data[9]);
            }

            Duration duracion = Duration.between(inicio, fin);

            long horas = duracion.toHours();
            long minutos = duracion.toMinutes() % 60;

            usuario.put("tiempoEnLinea", horas + "h " + minutos + "m");

            return usuario;

        }).collect(Collectors.toList());
    }
 }