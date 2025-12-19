// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.stereotype.Service;
// import com.example.demo.entity.ActivityLog;
// import com.example.demo.repository.ActivityLogRepository;
// import com.example.demo.service.ActivityLogService;

// @Service
// public class ActivityLogServiceImpl
//         implements ActivityLogService {

//     private final ActivityLogRepository repo;

//     public ActivityLogServiceImpl(ActivityLogRepository repo) {
//         this.repo = repo;
//     }

//     public ActivityLog create(ActivityLog log) {
//         return repo.save(log);
//     }

//     public ActivityLog get(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     public List<ActivityLog> getAll() {
//         return repo.findAll();
//     }

//     public ActivityLog update(Long id, ActivityLog log) {
//         log.setId(id);
//         return repo.save(log);
//     }

//     public void delete(Long id) {
//         repo.deleteById(id);
//     }
// }
