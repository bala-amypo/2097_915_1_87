package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activityName;
    private Double quantity;

    private LocalDateTime loggedAt = LocalDateTime.now();

    /* ================= REQUIRED BY TEST ================= */

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    /* ================= STANDARD GETTERS / SETTERS ================= */

    public Long getId() {
        return id;
    }

    public String getActivityName() {
        return activityName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
