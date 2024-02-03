package com.example.JobPortal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobPortal.entity.JobApplicant;
import com.example.JobPortal.repository.JobApplicantrepo;

@Service
public class JobApplicantservices {
	
	 @Autowired
	 public JobApplicantrepo jobapplicationrepo;
	 
	 public void createApplicant(JobApplicant jobappli) {
		 jobapplicationrepo.save(jobappli);
	 }
	 
	 public JobApplicant getJobApplicant(String email)
	 {
		 return jobapplicationrepo.findByEmailIgnoreCase(email);
	 }
}
