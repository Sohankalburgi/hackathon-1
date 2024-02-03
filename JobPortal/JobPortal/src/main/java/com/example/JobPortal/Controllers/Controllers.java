package com.example.JobPortal.Controllers;



import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.JobPortal.entity.JobApplicant;
import com.example.JobPortal.entity.JobCreator;

@RestController
public class Controllers {
	
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
	
	
	
}
