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
    private User user;

    @ManyToOne
    private ActivityType type;

    private double quantity;
    private double estimatedEmission;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;

    public ActivityLog() {}

    @PrePersist
    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public ActivityType getType() { return type; }
    public void setType(ActivityType type) { this.type = type; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
    public double getEstimatedEmission() { return estimatedEmission; }
    public void setEstimatedEmission(double estimatedEmission) { this.estimatedEmission = estimatedEmission; }
    public LocalDate getActivityDate() { return activityDate; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
    public LocalDateTime getLoggedAt() { return loggedAt; }
}
