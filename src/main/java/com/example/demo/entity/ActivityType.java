package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "activity_type")
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    private String unit;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ActivityCategory category;

    public ActivityType() {}

    public ActivityType(Long id, String typeName, String unit, ActivityCategory category) {
        this.id = id;
        this.typeName = typeName;
        this.unit = unit;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ActivityCategory getCategory() {
        return category;
    }

    public void setCategory(ActivityCategory category) {
        this.category = category;
    }
}
