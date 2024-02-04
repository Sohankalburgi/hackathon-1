package com.example.JobPortal.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.JobPortal.entity.JobCreator;
import com.example.JobPortal.repository.JobCreatorrepo;



@Service
public class JobCreatorServices {

	@Autowired
	public JobCreatorrepo jobcreatorrepo;
	
	public void createJob(JobCreator jobcreator)
	{
		jobcreatorrepo.save(jobcreator);
	}
	
	public JobCreator getjob(String email)
	{
		return jobcreatorrepo.findByEmailIgnoreCase(email);
	}
	
	public List<JobCreator> findalljobs()
	{
		return jobcreatorrepo.findAll();
	}
	
	public void savetoJobcreate( String name,String email,String Phone,String companyname,
			String Jobrole,String JobDescription,String skills1,String skills2,String skills3,String skills4,String skills5)
	{
		JobCreator jobcreator = jobcreatorrepo.findByEmailIgnoreCase(email);
		
		jobcreator.setName(name);
		jobcreator.setJobDescription(JobDescription);
		jobcreator.setPhoneNumber(Phone);
		jobcreator.setSkills1(skills1);
		jobcreator.setSkills2(skills2);
		jobcreator.setSkills3(skills3);
		jobcreator.setSkills4(skills4);
		jobcreator.setSkills5(skills5);
		jobcreator.setJobrole(Jobrole);
		
		
		jobcreatorrepo.save(jobcreator);
	}
	
	public JobCreator getByid(Integer id) {
		return jobcreatorrepo.getById(id);
	}
}
