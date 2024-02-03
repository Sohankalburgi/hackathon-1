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
	
	private String Jobrole;
	
	private String JobDescription;
	
	private String skills1;
	private String skills2;
	private String skills3;
	private String skills4;
	private String skills5;
	
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

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getSkills1() {
		return skills1;
	}

	public void setSkills1(String skills1) {
		this.skills1 = skills1;
	}

	public String getSkills2() {
		return skills2;
	}

	public void setSkills2(String skills2) {
		this.skills2 = skills2;
	}

	public String getSkills3() {
		return skills3;
	}

	public void setSkills3(String skills3) {
		this.skills3 = skills3;
	}

	public String getSkills4() {
		return skills4;
	}

	public void setSkills4(String skills4) {
		this.skills4 = skills4;
	}

	public String getSkills5() {
		return skills5;
	}

	public void setSkills5(String skills5) {
		this.skills5 = skills5;
	}
	
	
	
}
