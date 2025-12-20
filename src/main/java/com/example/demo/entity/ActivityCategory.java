package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_categories")
public class ActivityCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    private String description;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public ActivityCategory() { }

    public ActivityCategory(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public ActivityCategory(Long id, String categoryName, String description, LocalDateTime createdAt) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
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
