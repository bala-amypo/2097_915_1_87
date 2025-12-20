package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;
    private String unit;
    private LocalDateTime createdAt;

    @ManyToOne
    private ActivityCategory category;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public ActivityType(Long id, String typeName, String unit, LocalDateTime createdAt, ActivityCategory category) {
        this.id = id;
        this.typeName = typeName;
        this.unit = unit;
        this.createdAt = createdAt;
        this.category = category;
    }
}
