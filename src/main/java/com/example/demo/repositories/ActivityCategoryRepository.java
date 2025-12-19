package com.example.demo.repositories;

import com.example.demo.entity.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityCategoryRepository
        extends JpaRepository<ActivityCategory, Long> {
    boolean existsByCategoryName(String categoryName);
}
