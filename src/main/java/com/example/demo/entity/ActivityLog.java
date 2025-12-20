package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double quantity;

    private LocalDate activityDate;

    private Double estimatedEmission;

    @ManyToOne
    private User user;

    @ManyToOne
    private ActivityType activityType;

    // ===== Getters & Setters =====

    public Double getQuantity() {
        return quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public Double getEstimatedEmission() {
        return estimatedEmission;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public void setEstimatedEmission(Double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
