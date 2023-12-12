package com.lexy.demo.service;

import com.lexy.demo.model.PatientData;
import com.lexy.demo.repository.PatientDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientDataService.class);

    @Autowired
    private PatientDataRepository repository;

    public PatientData getLatestMeasurement(String label) {

        List<PatientData> results = repository.findLatestNumericalValues(label);
        for (PatientData result: results) { LOGGER.info(result.getValue()); }
        if (!results.isEmpty()) {
            for (PatientData result: results) {
                if (result.getValue().contains("cm") || result.getValue().contains("kg")) return result;
            }
            return results.get(0); // Get the first (most recent) record
        }
        throw new RuntimeException("No data found for label " + label);
    }
}
