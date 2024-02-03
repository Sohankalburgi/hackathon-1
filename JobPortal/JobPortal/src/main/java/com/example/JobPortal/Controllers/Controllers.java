package com.example.JobPortal.Controllers;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.JobPortal.entity.JobApplicant;
import com.example.JobPortal.entity.JobCreator;
import com.example.JobPortal.services.JobApplicantservices;
import com.example.JobPortal.services.JobCreatorServices;

@RestController
public class Controllers {
	
	
	@Autowired
	 JobCreatorServices jobcreatorservice;
	
	@Autowired
	JobApplicantservices jobApplicantservice;
	
	@GetMapping(path="/index")
	public ModelAndView getindexPage()
	{
		String viewName = "index";
		return new ModelAndView(viewName);
	}
	
	@GetMapping(path="/SigninJobCreator")
	public ModelAndView getSigninJobCreator(@ModelAttribute ("item") JobCreator jobcreator )
	{
		String viewName = "SigninJobCreator";
		Map<String,JobCreator> model = new HashMap<String, JobCreator>();
		model.put("item",new JobCreator());
		return new ModelAndView(viewName,model);
		
	}
	
	@GetMapping(path="/SigninJobApplicant")
	public ModelAndView getSigninJobApplicant(@ModelAttribute ("i") JobApplicant jobapplicant )
	{
		String viewName = "SigninJobApplicant";
		Map<String,JobApplicant> model = new HashMap<>();
		model.put("i",new JobApplicant());
		return new ModelAndView(viewName,model);
		
	}
	
	@GetMapping(path="/SignupJobCreator")
	public ModelAndView getSignupJobCreator(@ModelAttribute ("item") JobCreator jobcreator )
	{
		String viewName = "SignupJobCreator";
		Map<String,JobCreator> model = new HashMap<>();
		model.put("item",new JobCreator());
		return new ModelAndView(viewName,model);
		
	}
	
	@GetMapping(path="/SignupJobApplicant")
	public ModelAndView getSignupJobApplicant()
	{
		String viewName = "SignupJobApplicant";
		Map<String,JobApplicant> model = new HashMap<>();
		model.put("i",new JobApplicant());
		
		return new ModelAndView(viewName,model);
		
	}
	
	
	
	@PostMapping(path = "/SignupJobApplicant")
	public ModelAndView setSignupJobApplicant(@ModelAttribute ("i") JobApplicant jobapplicant)
	{
		JobApplicant check = jobApplicantservice.getJobApplicant(jobapplicant.getEmail());
		if(check!=null)
		{
			System.out.println("Can't create the applicant");
		}
		jobApplicantservice.createApplicant(jobapplicant);
		
		RedirectView rd = new  RedirectView();
		rd.setUrl("/Landuppage");
		return new ModelAndView(rd);
	}
	
	

	//2
	@PostMapping(path="/SignupJobCreator")
	public ModelAndView setSignupJobCreator(@ModelAttribute ("item") JobCreator jobcreator)
	{
		jobcreatorservice.createJob(jobcreator);
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/CreateJob");
		return new ModelAndView(rd);
	}
	
	//3
	@PostMapping(path="/SigninJobApplicant")
	public ModelAndView setSigninJobApplicant(@ModelAttribute("i") JobApplicant jobapp)
	{
		JobApplicant jobapplicant = jobApplicantservice.getJobApplicant(jobapp.getEmail());
		
		if(jobapplicant==null) {
			System.out.println("please create an account");
		}
		
		if(jobapplicant.getPassword().equals(jobapp.getPassword()))
		{
			System.out.println("successful login");
			RedirectView rd = new RedirectView();
			rd.setUrl("Landuppage");
			return new ModelAndView(rd);
		}
		return new ModelAndView("error");
		
	}
	
	//4
	@PostMapping(path="/SigninJobCreator")
	public ModelAndView setSigninJobCreator(@ModelAttribute("item") JobCreator jobcre)
	{
		JobCreator jobacreator = jobcreatorservice.getjob(jobcre.getEmail());
		
		if(jobacreator==null) {
			System.out.println("please create an account");
		}
		
		if(jobacreator.getPassword().equals(jobcre.getPassword()))
		{
			System.out.println("successful login");
			RedirectView rd = new RedirectView();
			rd.setUrl("Landuppage");
			return new ModelAndView(rd);
		}
		return new ModelAndView("error");
		
	}
	
	@GetMapping(path="/Landuppage")
	public ModelAndView getLanduppage()
	{
		String viewName = "Landuppage";
		Map<String,List<JobCreator>> model = new HashMap<>();
		model.put("item",jobcreatorservice.findalljobs());
		return new ModelAndView(viewName,model);
	}
	
	@GetMapping(path="/CreateJob")
	public ModelAndView getcreateJob()
	{
		String viewName = "CreateJob";
		Map<String,Object>model = new HashMap<>();
		model.put("item",new JobCreator());

		return new ModelAndView(viewName,model);
	}
	
	@PostMapping(path = "/CreateJob")
	public ModelAndView setcreateJob(@ModelAttribute("item") JobCreator jobcreator)
	{
		jobcreatorservice.savetoJobcreate(jobcreator.getName(),jobcreator.getEmail(),jobcreator.getPhoneNumber(),jobcreator.getCompanyName(),
				jobcreator.getJobrole(),jobcreator.getJobDescription(),jobcreator.getSkills1(),jobcreator.getSkills2(),jobcreator.getSkills3(),jobcreator.getSkills4(),jobcreator.getSkills5());
		return new ModelAndView("Landuppage");
	}
	
	@GetMapping(path="/Apply")
	public ModelAndView getApplypage()
	{
//		Map<String,JobApplicant> app = new HashMap<>();
//		app.put("appli",new JobApplicant());
		return new ModelAndView("Apply");
	}
	
	@PostMapping(path="/Apply")
	public ModelAndView setApplyPage(@RequestParam("Name") String name,@RequestParam("Email") String email,@RequestParam("LinkedIn") String Linkedin,
			@RequestParam("PhoneNumber")String Phone,@RequestParam("skills1")String skills1,@RequestParam("skills2") String skills2,
			@RequestParam("skills3")String skills3,@RequestParam("skills4") String skills4,@RequestParam("skills5")String skills5,@ModelAttribute("About")String about) {
		JobApplicant jobapp = new JobApplicant();
		jobapp.setEmail(email);
		jobapp.setLinkedIn(Linkedin);
		jobapp.setTechnicalSkills1(skills1);
		jobapp.setTechnicalSkills2(skills2);
		jobapp.setTechnicalSkills3(skills3);
		jobapp.setTechnicalSkills4(skills4);
		jobapp.setTechnicalSkills5(skills5);
		jobapp.setPhoneNumber(Phone);
		jobapp.setAbout(about);
		jobApplicantservice.createApplicant(jobapp);
		return new ModelAndView("successful");
	}
	
	
}
