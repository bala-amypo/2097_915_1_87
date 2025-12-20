package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double quantity;

    private double estimatedEmission;   // ✅ REQUIRED FIELD

    private LocalDate activityDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private ActivityType activityType;

    public ActivityLog() {}

    @PrePersist
    public void prePersist() {}

    // ---------- GETTERS ----------
    public double getQuantity() {
        return quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public double getEstimatedEmission() {
        return estimatedEmission;
    }

    // ---------- SETTERS ----------
    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public void setEstimatedEmission(double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }
}
