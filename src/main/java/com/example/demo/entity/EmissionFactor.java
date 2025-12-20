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

    public EmissionFactor(Long id, ActivityType activityType,
                          double factorValue, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.activityType = activityType;
        this.factorValue = factorValue;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public void setFactorValue(double v) { this.factorValue = v; }
    public void setUnit(String u) { this.unit = u; }
    public ActivityType getActivityType() { return activityType; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
