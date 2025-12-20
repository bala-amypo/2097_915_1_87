package com.example.demo.dto;

import java.time.LocalDate;

public class ActivityLogRequest {

    private double quantity;
    private LocalDate activityDate;

    public ActivityLogRequest() {
    }

    public ActivityLogRequest(double quantity, LocalDate activityDate) {
        this.quantity = quantity;
        this.activityDate = activityDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }
}
