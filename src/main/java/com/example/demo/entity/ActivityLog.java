package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double quantity;
    private LocalDate activityDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private ActivityType activityType;

    public ActivityLog() {}

    @PrePersist
    public void prePersist() {}

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
