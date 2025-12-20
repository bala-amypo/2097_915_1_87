package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private double estimatedEmission; // renamed from carbonEmission

    @PrePersist
    public void prePersist() {
        loggedAt = LocalDateTime.now();
    }
}
