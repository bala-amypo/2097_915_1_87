package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    private double factorValue;
    private String unit;
    private LocalDateTime createdAt;

    public EmissionFactor() {}

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public ActivityType getActivityType() { return activityType; }
    public double getFactorValue() { return factorValue; }
    public String getUnit() { return unit; }

    public void setId(Long id) { this.id = id; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
    public void setFactorValue(double factorValue) { this.factorValue = factorValue; }
    public void setUnit(String unit) { this.unit = unit; }
}
