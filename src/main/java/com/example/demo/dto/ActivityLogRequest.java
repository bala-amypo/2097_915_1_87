package com.example.demo.dto;

import java.time.LocalDate;

public class ActivityLogRequest {

    private double emission;
    private LocalDate date;

    // REQUIRED no-args constructor
    public ActivityLogRequest() {
    }

    // REQUIRED constructor used by tests
    public ActivityLogRequest(double emission, LocalDate date) {
        this.emission = emission;
        this.date = date;
    }

    public double getEmission() {
        return emission;
    }

    public void setEmission(double emission) {
        this.emission = emission;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
