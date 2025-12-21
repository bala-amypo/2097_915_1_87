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
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType activityType;

    private Double factorValue;

    private String unit;

    private LocalDateTime createdAt;

    public EmissionFactor() {
    }

    public EmissionFactor(Long id, ActivityType activityType, Double factorValue, String unit, LocalDateTime createdAt) {
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

    public Long getId() { return id; }
    public ActivityType getActivityType() { return activityType; }
    public Double getFactorValue() { return factorValue; }
    public String getUnit() { return unit; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
    public void setFactorValue(Double factorValue) { this.factorValue = factorValue; }
    public void setUnit(String unit) { this.unit = unit; }
}
