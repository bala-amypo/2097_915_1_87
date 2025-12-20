package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_types")
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    private String unit;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ActivityCategory category;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public ActivityType() { }

    public ActivityType(Long id, String typeName, String unit, ActivityCategory category) {
        this.id = id;
        this.typeName = typeName;
        this.unit = unit;
        this.category = category;
    }

    public ActivityType(Long id, String typeName, ActivityCategory category, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.typeName = typeName;
        this.category = category;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Getters and Setters
    // ...
}
