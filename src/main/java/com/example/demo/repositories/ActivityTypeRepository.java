package com.example.carbonfootprint.repository;

import com.example.carbonfootprint.entity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
    List<ActivityType> findByCategoryId(Long categoryId);
}
