package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activityType;
    private Double factorValue;

    private LocalDateTime createdAt = LocalDateTime.now();

    /* ================= REQUIRED BY TEST ================= */

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /* ================= STANDARD GETTERS / SETTERS ================= */

    public Long getId() {
        return id;
    }

    public String getActivityType() {
        return activityType;
    }

    public Double getFactorValue() {
        return factorValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public void setFactorValue(Double factorValue) {
        this.factorValue = factorValue;
    }
}
