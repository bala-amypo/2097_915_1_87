package com.example.demo.dto;

import java.time.LocalDate;

public class ActivityLogRequest {

    private double emission;
    private LocalDate date;

    public ActivityLogRequest() {
    }

    public ActivityLogRequest(double emission, LocalDate date) {
        this.emission = emission;
        this.date = date;
    }

    // getters and setters
}
