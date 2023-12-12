package com.lexy.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patient_data")
public class PatientData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    private LocalDate measuredDate;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDate getMeasuredDate() {
        return measuredDate;
    }

    public void setMeasuredDate(LocalDate measuredDate) {
        this.measuredDate = measuredDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
