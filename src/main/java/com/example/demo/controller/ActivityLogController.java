package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    @PostMapping("/add")
    public ActivityLog logActivity(@RequestBody ActivityLog log) {
        return activityLogService.logActivity(log); // must match service method
    }

    @GetMapping("/all")
    public List<ActivityLog> getAllLogs() {
        return activityLogService.getLogsByUser(null); // or use proper userId
    }

    @GetMapping("/{id}")
    public ActivityLog getLog(@PathVariable Long id) {
        return activityLogService.getById(id).orElse(null); // Optional to entity
    }
}
