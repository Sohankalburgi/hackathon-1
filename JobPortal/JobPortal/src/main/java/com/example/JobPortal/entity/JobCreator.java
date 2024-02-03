package com.example.JobPortal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class JobCreator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String Name;
	
	private String Email;
	
	private String Password;
	
	private String PhoneNumber;
	
	private String CompanyName;
	
	private String JobDescription;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	
	private String SkillsNeeded;
	
	private String aboutCompany;

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
		Name = name;
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

	public String getEPhoneNumber() {
		return PhoneNumber;
	}

	public void setEPhoneNumber(String ePhoneNumber) {
		PhoneNumber = ePhoneNumber;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getJobDescription() {
		return JobDescription;
	}

	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSkillsNeeded() {
		return SkillsNeeded;
	}

	public void setSkillsNeeded(String skillsNeeded) {
		SkillsNeeded = skillsNeeded;
	}

	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}
	
	
}
