package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate activityDate;

    private double quantity;

    private double estimatedEmission;

    private LocalDateTime loggedAt = LocalDateTime.now();

    @ManyToOne
    private User user;

    @ManyToOne
    private ActivityType activityType;

    /* ===== REQUIRED GETTERS / SETTERS ===== */

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public void setEstimatedEmission(double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }

    public Long getId() {
        return id;
    }
}
