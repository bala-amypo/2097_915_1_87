package com.example.demo.controller;

import com.example.demo.dto.ActivityLogRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activity")
public class ActivityLogController {

    @PostMapping
    public ResponseEntity<String> logActivity(@RequestBody ActivityLogRequest req) {

        double quantity = req.getQuantity();
        var date = req.getActivityDate();

        // business logic placeholder
        return ResponseEntity.ok("Activity logged: " + quantity + " on " + date);
    }
}
