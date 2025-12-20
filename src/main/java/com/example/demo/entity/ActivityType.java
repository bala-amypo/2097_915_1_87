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

    @ManyToOne
    private ActivityCategory category;

    private LocalDateTime createdAt;

    public ActivityType() {}

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getTypeName() { return typeName; }
    public String getUnit() { return unit; }
    public ActivityCategory getCategory() { return category; }

    public void setId(Long id) { this.id = id; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
    public void setUnit(String unit) { this.unit = unit; }
    public void setCategory(ActivityCategory category) { this.category = category; }
}
