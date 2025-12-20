package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String unit;

    @ManyToOne
    private ActivityCategory category;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public ActivityCategory getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCategory(ActivityCategory category) {
        this.category = category;
    }
}
