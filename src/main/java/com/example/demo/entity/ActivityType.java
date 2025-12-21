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
    @JoinColumn(name = "category_id", nullable = false)
    private ActivityCategory category;

    private LocalDateTime createdAt;

    public ActivityType() {
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

    public Long getId() { return id; }
    public String getTypeName() { return typeName; }
    public ActivityCategory getCategory() { return category; }
    public String getUnit() { return unit; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
    public void setCategory(ActivityCategory category) { this.category = category; }
    public void setUnit(String unit) { this.unit = unit; }
}
