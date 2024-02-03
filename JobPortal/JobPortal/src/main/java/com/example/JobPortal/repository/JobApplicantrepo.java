package com.example.JobPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.JobPortal.entity.JobApplicant;



@Repository
public interface JobApplicantrepo extends JpaRepository<JobApplicant, Integer>{
	@Query("SELECT j FROM JobApplicant j WHERE UPPER(j.Email) = UPPER(:email)")
	JobApplicant findByEmailIgnoreCase(String email);
}