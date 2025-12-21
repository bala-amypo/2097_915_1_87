package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private double value;
    private LocalDate logDate;
    private LocalDateTime createdAt;
    private double carbonFootprint;

    public ActivityLog() {
    }

    public ActivityLog(Long id, ActivityType activityType, User user, double value,
                       LocalDate logDate, LocalDateTime createdAt, double carbonFootprint) {
        this.id = id;
        this.activityType = activityType;
        this.user = user;
        this.value = value;
        this.logDate = logDate;
        this.createdAt = createdAt;
        this.carbonFootprint = carbonFootprint;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ActivityType getActivityType() { return activityType; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public LocalDate getLogDate() { return logDate; }
    public void setLogDate(LocalDate logDate) { this.logDate = logDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public double getCarbonFootprint() { return carbonFootprint; }
    public void setCarbonFootprint(double carbonFootprint) { this.carbonFootprint = carbonFootprint; }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
