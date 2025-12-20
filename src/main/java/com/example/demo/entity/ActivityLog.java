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

    private double quantity;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private double estimatedEmission;

    public ActivityLog() {}

    public ActivityLog(Long id, ActivityType activityType, User user,
                       double quantity, LocalDate activityDate,
                       LocalDateTime loggedAt, double estimatedEmission) {
        this.id = id;
        this.activityType = activityType;
        this.user = user;
        this.quantity = quantity;
        this.activityDate = activityDate;
        this.loggedAt = loggedAt;
        this.estimatedEmission = estimatedEmission;
    }

    @PrePersist
    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }

    public User getUser() { return user; }
    public ActivityType getActivityType() { return activityType; }
    public LocalDateTime getLoggedAt() { return loggedAt; }
}
