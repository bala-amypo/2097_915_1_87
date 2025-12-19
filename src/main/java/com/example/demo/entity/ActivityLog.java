// package com.example.demo.entity;

// import java.time.LocalDate;
// import jakarta.persistence.*;

// @Entity
// public class ActivityLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Double quantity;
//     private LocalDate activityDate;

//     @ManyToOne
//     private User user;

//     @ManyToOne
//     private ActivityType activityType;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Double getQuantity() { return quantity; }
//     public void setQuantity(Double quantity) { this.quantity = quantity; }

//     public LocalDate getActivityDate() { return activityDate; }
//     public void setActivityDate(LocalDate activityDate) {
//         this.activityDate = activityDate;
//     }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }

//     public ActivityType getActivityType() { return activityType; }
//     public void setActivityType(ActivityType activityType) {
//         this.activityType = activityType;
//     }
// }
