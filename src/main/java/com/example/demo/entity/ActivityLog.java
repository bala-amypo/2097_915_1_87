package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
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
    private Double amount; // Tests use getAmount/setAmount
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private Double estimatedEmission;

    @PrePersist
    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }
}