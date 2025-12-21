package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private Double quantity;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private Double estimatedEmission;

    public ActivityLog() {}

    // ✅ REQUIRED FULL CONSTRUCTOR (TESTS USE THIS)
    public ActivityLog(Long id,
                       ActivityType activityType,
                       User user,
                       Double quantity,
                       LocalDate activityDate,
                       LocalDateTime loggedAt,
                       Double estimatedEmission) {
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

    // ✅ REQUIRED BY TESTS
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public ActivityType getActivityType() {
        return activityType;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public void setEstimatedEmission(Double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }
}
