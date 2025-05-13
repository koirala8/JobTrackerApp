package com.apply24hours.jobtracker.repository;

import com.apply24hours.jobtracker.entity.JobApplication;
import com.apply24hours.jobtracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepo extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByUser(User user); // Get all job applications for a user

    List<JobApplication> findByUserId(Long userId); // Same but by userId

    List<JobApplication> findByStatus(String status); // Filter by status

}
