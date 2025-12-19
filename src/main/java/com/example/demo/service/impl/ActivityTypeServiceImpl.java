// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.stereotype.Service;
// import com.example.demo.entity.ActivityType;
// import com.example.demo.repository.ActivityTypeRepository;
// import com.example.demo.service.ActivityTypeService;

// @Service
// public class ActivityTypeServiceImpl implements ActivityTypeService {

//     private final ActivityTypeRepository repo;

//     public ActivityTypeServiceImpl(ActivityTypeRepository repo) {
//         this.repo = repo;
//     }

//     public ActivityType create(ActivityType t) {
//         return repo.save(t);
//     }

//     public ActivityType get(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     public List<ActivityType> getAll() {
//         return repo.findAll();
//     }

//     public ActivityType update(Long id, ActivityType t) {
//         t.setId(id);
//         return repo.save(t);
//     }

//     public void delete(Long id) {
//         repo.deleteById(id);
//     }
// }
