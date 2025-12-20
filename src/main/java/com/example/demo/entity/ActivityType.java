package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;
    private String unit;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ActivityCategory category;

    public ActivityType() {}

    public ActivityType(Long id, String typeName, String unit, ActivityCategory category, LocalDateTime createdAt) {
        this.id = id;
        this.typeName = typeName;
        this.unit = unit;
        this.category = category;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public void setCategory(ActivityCategory category) {
        this.category = category;
    }

    public String getTypeName() { return typeName; }
    public String getUnit() { return unit; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
