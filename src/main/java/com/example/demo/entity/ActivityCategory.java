package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ActivityCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    private String description;

    public ActivityCategory() {}

    public ActivityCategory(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
