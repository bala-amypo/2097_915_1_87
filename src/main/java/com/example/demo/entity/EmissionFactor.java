package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double factorValue;

    @ManyToOne
    private ActivityType activityType;

    // Getters & Setters
    public Double getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(Double factorValue) {
        this.factorValue = factorValue;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
