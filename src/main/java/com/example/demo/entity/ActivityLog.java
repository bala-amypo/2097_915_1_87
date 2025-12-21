package com.example.carbonfootprint.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double quantity;

    private LocalDate activityDate;

    private double estimatedEmission;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "activity_type_id")
    private ActivityType activityType;

    public ActivityLog() {}

    public ActivityLog(double quantity, LocalDate activityDate, User user, ActivityType activityType) {
        this.quantity = quantity;
        this.activityDate = activityDate;
        this.user = user;
        this.activityType = activityType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    public LocalDate getActivityDate() { return activityDate; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }

    public double getEstimatedEmission() { return estimatedEmission; }
    public void setEstimatedEmission(double estimatedEmission) { this.estimatedEmission = estimatedEmission; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public ActivityType getActivityType() { return activityType; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
}
