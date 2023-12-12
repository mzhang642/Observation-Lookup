package com.lexy.demo.repository;

import com.lexy.demo.model.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientDataRepository extends JpaRepository<PatientData, Long> {
    @Query("SELECT p FROM PatientData p WHERE p.label = :label ORDER BY p.measuredDate DESC")
    List<PatientData> findLatestNumericalValues(String label);

}
