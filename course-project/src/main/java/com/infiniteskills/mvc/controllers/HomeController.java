package com.infiniteskills.mvc.controllers;
import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
/*import org.springframework.web.bind.annotation.ResponseBody;*/
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
/*	@Autowired
	private ProjectService service;*/
	
/*	@RequestMapping("/home")
	@ResponseBody
	public String goHome(){
		return "Welcome HOme";
	}*/
	
/*	@RequestMapping("/home")
	public String goHome(){
		return "home";
	}*/
/*
	@RequestMapping(value="/", params="projectId")
	public String goHomeAgain(Model model, @RequestParam("projectId") Long projectId){
		model.addAttribute("currentProject", this.service.find(projectId));
		return "home";
	}*/
	
	@RequestMapping(value="/")
	public String goHomeAgain(Model model, @ModelAttribute("project") Project project){
		model.addAttribute("currentProject", project);
		return "home";
	}	
	
	
	
	
/*	@RequestMapping("/")
	public String goHome(Model model){
		Project project = new Project();
		project.setName("First Project");
		//project.setSponsor("Nasa");
		project.setDescription("This is a simple project sponsored by NASA");
		
		model.addAttribute("currentProject", project);
		return "welcome";
	}	
*/
}
