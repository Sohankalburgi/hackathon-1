package com.example.JobPortal.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controllers {
	
	@GetMapping(path="/index")
	public ModelAndView getindexPage()
	{
		String viewName = "index";
		return new ModelAndView(viewName);
	}
	
	
	
}
