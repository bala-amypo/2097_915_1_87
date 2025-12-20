package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double factorValue;

    @ManyToOne
    private ActivityType activityType;

    public EmissionFactor() {}

    public double getFactorValue() {
        return factorValue;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
