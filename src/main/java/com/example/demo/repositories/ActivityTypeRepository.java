package com.example.demo.repository;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
    List<ActivityType> findByCategory(ActivityCategory category);
}
