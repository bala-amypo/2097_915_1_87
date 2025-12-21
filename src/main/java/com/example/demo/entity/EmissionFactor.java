package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emission_factors")
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    private Double factorValue;
    private String unit;
    private LocalDateTime createdAt;

    public EmissionFactor() {}

    public EmissionFactor(Long id, ActivityType activityType,
                          Double factorValue, String unit,
                          LocalDateTime createdAt) {
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

    // ✅ REQUIRED BY TESTS
    public void setId(Long id) {
        this.id = id;
    }

    public void setFactorValue(Double factorValue) {
        this.factorValue = factorValue;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public Long getId() {
        return id;
    }
}
