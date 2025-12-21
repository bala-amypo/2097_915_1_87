package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EmissionFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ActivityType type;

    private double factorValue;

    public EmissionFactor() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ActivityType getType() { return type; }
    public void setType(ActivityType type) { this.type = type; }
    public double getFactorValue() { return factorValue; }
    public void setFactorValue(double factorValue) { this.factorValue = factorValue; }
}
