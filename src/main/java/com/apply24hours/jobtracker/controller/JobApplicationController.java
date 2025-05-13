package com.apply24hours.jobtracker.controller;

import com.apply24hours.jobtracker.entity.JobApplication;
import com.apply24hours.jobtracker.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    // Create a new job application
    @PostMapping
    public ResponseEntity<JobApplication> createApplication(@RequestBody JobApplication jobApplication) {
        return ResponseEntity.ok(jobApplicationService.saveJobApplication(jobApplication));
    }

    // Get all applications
    @GetMapping
    public ResponseEntity<List<JobApplication>> getAllApplications() {
        return ResponseEntity.ok(jobApplicationService.getAllApplications());
    }

    // Get application by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getApplicationById(@PathVariable Long id) {
        return ResponseEntity.ok(jobApplicationService.getApplicationById(id));
    }

    // Get applications for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<JobApplication>> getApplicationsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(jobApplicationService.getApplicationsByUserId(userId));
    }

    // Get applications by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<JobApplication>> getApplicationsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(jobApplicationService.getApplicationsByStatus(status));
    }

    // Delete application
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        jobApplicationService.deleteJobApplication(id);
        return ResponseEntity.ok("Application deleted successfully");
    }
}
