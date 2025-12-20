package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    private double value;
    private String unit;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public EmissionFactor(Long id, ActivityType activityType, double value, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.activityType = activityType;
        this.value = value;
        this.unit = unit;
        this.createdAt = createdAt;
    }
}
