package com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.service.DataService;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private DataService service;

    @GetMapping("/datos")
    public List<Map<String, Object>> datos(
            @RequestParam(required = false) String loginTime
    ) throws IOException {
        return service.getDatos(loginTime);
    }
}