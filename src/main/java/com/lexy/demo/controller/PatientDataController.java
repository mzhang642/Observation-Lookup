package com.lexy.demo.controller;

import com.lexy.demo.service.PatientDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/patient")
public class PatientDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientDataController.class);

    @Autowired
    private PatientDataService service;

    @GetMapping("/latest")
    public ResponseEntity<Map<String, String>> getLatestMeasurements() {
        Map<String, String> results = new HashMap<>();
        results.put("height", service.getLatestMeasurement("height").getValue());
        results.put("weight", service.getLatestMeasurement("weight").getValue());
        return ResponseEntity.ok(results);
    }
}
