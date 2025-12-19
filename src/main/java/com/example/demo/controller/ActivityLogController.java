// package com.example.demo.controller;

// import java.util.List;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.entity.ActivityLog;
// import com.example.demo.service.ActivityLogService;

// @RestController
// @RequestMapping("/logs")
// public class ActivityLogController {

//     private final ActivityLogService service;

//     public ActivityLogController(ActivityLogService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ActivityLog create(@RequestBody ActivityLog log) {
//         return service.create(log);
//     }

//     @GetMapping("/{id}")
//     public ActivityLog get(@PathVariable Long id) {
//         return service.get(id);
//     }

//     @GetMapping
//     public List<ActivityLog> getAll() {
//         return service.getAll();
//     }

//     @PutMapping("/{id}")
//     public ActivityLog update(@PathVariable Long id,
//                               @RequestBody ActivityLog log) {
//         return service.update(id, log);
//     }

//     @DeleteMapping("/{id}")
//     public void delete(@PathVariable Long id) {
//         service.delete(id);
//     }
// }
