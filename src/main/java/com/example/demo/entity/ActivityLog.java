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

    @ManyToOne(optional = false)
    private ActivityType activityType;

    @ManyToOne(optional = false)
    private User user;

    private Double quantity;

    private LocalDate activityDate;

    private LocalDateTime loggedAt;

    private Double estimatedEmission;

    @PrePersist
    public void onCreate() {
        loggedAt = LocalDateTime.now();
    }

    public ActivityLog() {}

    public ActivityLog(Long id, ActivityType activityType,
                       User user, Double quantity,
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

    // Getters and Setters
}
