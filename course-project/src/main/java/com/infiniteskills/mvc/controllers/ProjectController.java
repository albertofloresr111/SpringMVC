package com.infiniteskills.mvc.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infiniteskills.mvc.data.validators.ProjectValidator;
import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.services.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value="/{projectId}")
	public String findProjects(Model model, @PathVariable("projectId") Long projectId){
		model.addAttribute("project", this.projectService.find(projectId));
		return "project";
	}

	@RequestMapping(value="find/{projectId}")
	public @ResponseBody Project findProject(Model model, @PathVariable("projectId") Long projectId){
		
		return this.projectService.find(projectId);
	}	
	
	
	@RequestMapping(value="/find")
	public String find(Model model){
		model.addAttribute("projects", this.projectService.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addProject(Model model){

		model.addAttribute("types", new ArrayList<String>(){{
			add("");
			add("Single Year");
			add("Multi Year");
		}});
		
		model.addAttribute("project", new Project());

		return "project_add";
	}

/*	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors, RedirectAttributes attributes){
		
		if(!errors.hasErrors()){
			System.out.println("The project validated");
		}else{
			System.out.println("The project did not validated");
			return "project_add";
		}
			
		
		System.out.println("invoking saveProject");
		System.out.println(project);
		project.setProjectId(55L);
		this.projectService.save(project);
		attributes.addAttribute("projectId", project.getProjectId().toString());
		return "redirect:/";
	}*/
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors, RedirectAttributes attributes){
		
/*		if(!errors.hasErrors()){
			System.out.println("The project validated");
		}else{
			System.out.println("The project did not validated");
			return "project_add";
		}
			
		
		System.out.println("invoking saveProject");
		System.out.println(project);*/
		//project.setProjectId(55L);
		//this.projectService.save(project);
		//attributes.addFlashAttribute("project", project);
		//throw new NullPointerException();
		//return "redirect:/";
		
		if(errors.hasErrors()){
			return "project_add";
		}
		
		project.setProjectId(55L);
		this.projectService.save(project);
		System.out.println(project);
		
		attributes.addFlashAttribute("project", project);
		return "redirect:/";
		
	}	

	
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProjectValidator());
	} 	
*/
}
