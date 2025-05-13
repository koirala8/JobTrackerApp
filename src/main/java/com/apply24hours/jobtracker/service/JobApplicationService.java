package com.apply24hours.jobtracker.service;

import com.apply24hours.jobtracker.entity.JobApplication;
import com.apply24hours.jobtracker.entity.User;
import com.apply24hours.jobtracker.exception.ResourceNotFoundException;
import com.apply24hours.jobtracker.repository.JobApplicationRepo;
import com.apply24hours.jobtracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepo jobApplicationRepository;

    @Autowired
    private UserRepo userRepository;

    public JobApplication saveJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public List<JobApplication> getAllApplications() {
        return jobApplicationRepository.findAll();
    }

    public List<JobApplication> getApplicationsByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User with ID " + userId + " not found");
        }
        return jobApplicationRepository.findByUserId(userId);
    }

    public List<JobApplication> getApplicationsByStatus(String status) {
        return jobApplicationRepository.findByStatus(status);
    }

    public JobApplication getApplicationById(Long id) {
        return jobApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job Application with ID " + id + " not found"));
    }

    public void deleteJobApplication(Long id) {
        JobApplication app = getApplicationById(id);
        jobApplicationRepository.delete(app);
    }
}
