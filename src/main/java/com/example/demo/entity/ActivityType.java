package com.example.carbonfootprint.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "activity_types")
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String typeName;

    private String unit; // e.g., km, kWh, liters

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ActivityCategory category;

    @OneToMany(mappedBy = "activityType", cascade = CascadeType.ALL)
    private Set<EmissionFactor> emissionFactors;

    public ActivityType() {}

    public ActivityType(String typeName, String unit, ActivityCategory category) {
        this.typeName = typeName;
        this.unit = unit;
        this.category = category;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public ActivityCategory getCategory() { return category; }
    public void setCategory(ActivityCategory category) { this.category = category; }

    public Set<EmissionFactor> getEmissionFactors() { return emissionFactors; }
    public void setEmissionFactors(Set<EmissionFactor> emissionFactors) { this.emissionFactors = emissionFactors; }
}
