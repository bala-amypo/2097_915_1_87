package com.example.carbonfootprint.repository;

import com.example.carbonfootprint.entity.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Long> {
    boolean existsByCategoryName(String categoryName);
    Optional<ActivityCategory> findByCategoryName(String categoryName);
}
