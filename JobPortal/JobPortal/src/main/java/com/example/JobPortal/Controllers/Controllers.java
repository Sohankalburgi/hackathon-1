package com.example.JobPortal.Controllers;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ModelAndView getSigninJobApplicant(@ModelAttribute ("item") JobApplicant jobapplicant )
	{
		String viewName = "SigninJobApplicant";
		Map<String,JobApplicant> model = new HashMap<>();
		model.put("item",new JobApplicant());
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
	public ModelAndView getSignupJobApplicant(@ModelAttribute ("item") JobApplicant jobapplicant )
	{
		String viewName = "SigninJobApplicant";
		Map<String,JobApplicant> model = new HashMap<>();
		model.put("item",new JobApplicant());
		
		return new ModelAndView(viewName,model);
		
	}
	
	
	//1
	@PostMapping(path = "/SignupJobApplicant")
	public ModelAndView setSignupJobApplicant(@ModelAttribute ("item") JobApplicant jobapplicant)
	{
		jobApplicantservice.createApplicant(jobapplicant);
		
		RedirectView rd = new  RedirectView();
		rd.setUrl("/CreateJob");
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
	public ModelAndView setSigninJobApplicant(@ModelAttribute("item") JobApplicant jobapp)
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
		model.put("JobRoles",jobcreatorservice.findalljobs());
		return new ModelAndView(viewName,model);
	}
	
	@GetMapping(path="/CreateJob")
	public ModelAndView getcreateJob()
	{
		String viewName = "CreateJob";
		return new ModelAndView(viewName);
	}
	
	@PostMapping(path = "/CreateJob")
	public ModelAndView setcreateJob(@RequestParam("file") MultipartFile file,@RequestParam("Name") String name,
			@RequestParam("Email") String Email,@RequestParam)
	
	
	
	
	
	
}
