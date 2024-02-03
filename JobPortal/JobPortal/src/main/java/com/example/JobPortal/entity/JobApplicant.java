package com.example.JobPortal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class JobApplicant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer jobid;
	
	private String Name;
	@jakarta.validation.constraints.Email
	private String Email;
	
	private String Password;
	
	private String PhoneNumber;
	
	private String LinkedIn;
	
	private String About;
	 
	private String technicalSkills1;
	 
	private String technicalSkills2;
	
	private String technicalSkills3;
	
	private String technicalSkills4;
	
	private String technicalSkills5;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getAbout() {
		return About;
	}

	public void setAbout(String about) {
		About = about;
	}

	public String getTechnicalSkills1() {
		return technicalSkills1;
	}

	public void setTechnicalSkills1(String technicalSkills1) {
		this.technicalSkills1 = technicalSkills1;
	}

	public String getTechnicalSkills2() {
		return technicalSkills2;
	}

	public void setTechnicalSkills2(String technicalSkills2) {
		this.technicalSkills2 = technicalSkills2;
	}

	public String getTechnicalSkills3() {
		return technicalSkills3;
	}

	public void setTechnicalSkills3(String technicalSkills3) {
		this.technicalSkills3 = technicalSkills3;
	}

	public String getTechnicalSkills4() {
		return technicalSkills4;
	}

	public void setTechnicalSkills4(String technicalSkills4) {
		this.technicalSkills4 = technicalSkills4;
	}

	public String getTechnicalSkills5() {
		return technicalSkills5;
	}

	public void setTechnicalSkills5(String technicalSkills5) {
		this.technicalSkills5 = technicalSkills5;
	}

	public Integer getJobid() {
		return jobid;
	}

	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}

	public String getLinkedIn() {
		return LinkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		LinkedIn = linkedIn;
	}
	
	
	

	
	
	
	
	
}
