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
	
	public void savetoJobcreate(MultipartFile file, String name,String email,String Phone,String companyname,
			String Jobrole,String JobDescription,String skills1,String skills2,String skills3,String skills4,String skills5)
	{
		JobCreator jobcreator = jobcreatorrepo.findByEmailIgnoreCase(email);
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			jobcreator.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jobcreator.setName(name);
		jobcreator.setJobDescription(JobDescription);
		jobcreator.setPhoneNumber(Phone);
		jobcreator.setSkills1(skills1);
		jobcreator.setSkills2(skills2);
		job
		
		
		jobcreatorrepo.save(jobcreator);
	}
	
}
