package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "activity_category")
public class ActivityCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ActivityType> types;

    public ActivityCategory() {}

    public ActivityCategory(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ActivityType> getTypes() {
        return types;
    }

    public void setTypes(List<ActivityType> types) {
        this.types = types;
    }
}
