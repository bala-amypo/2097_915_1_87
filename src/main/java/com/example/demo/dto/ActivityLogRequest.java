package com.example.demo.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLogRequest {
    private double amount;
    private LocalDate date;
}