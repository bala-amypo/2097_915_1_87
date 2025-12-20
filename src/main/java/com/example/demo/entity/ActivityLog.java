package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private double quantity;           // renamed from amount
    private LocalDate activityDate;    // renamed from date
    private LocalDateTime loggedAt;
    private double carbonEmission;

    @PrePersist
    public void prePersist() {
        loggedAt = LocalDateTime.now();
    }
}
