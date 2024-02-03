package com.example.JobPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.JobPortal.entity.JobCreator;


public interface JobCreatorrepo extends JpaRepository<JobCreator, Integer>{
	@Query("SELECT j FROM JobCreator j WHERE UPPER(j.Email) = UPPER(:email)")
	JobCreator findByEmailIgnoreCase(String email);
}
