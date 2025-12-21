package com.example.carbonfootprint.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emission_factors")
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double factorValue;

    @ManyToOne
    @JoinColumn(name = "activity_type_id")
    private ActivityType activityType;

    public EmissionFactor() {}

    public EmissionFactor(double factorValue, ActivityType activityType) {
        this.factorValue = factorValue;
        this.activityType = activityType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getFactorValue() { return factorValue; }
    public void setFactorValue(double factorValue) { this.factorValue = factorValue; }

    public ActivityType getActivityType() { return activityType; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
}
