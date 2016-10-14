package com.infiniteskills.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.infiniteskills.mvc.data.entities.Resource;
import com.infiniteskills.mvc.data.services.ResourceService;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {
	@Autowired
	private ResourceService service;

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public @ResponseBody String handleUpload(@RequestParam("file") MultipartFile file ){
		if(!file.isEmpty()){
			return "The file size is "+ file.getSize();
		} else {
			return "There was a problem";
		}
	
	}	
	
	@RequestMapping("/add")
	public String add(Model model){
		System.out.println("Invking add()");
/*		List<String> options = new LinkedList<>(Arrays.asList(
				new String[] {"Material","Other","Staff","Technical Equipment"}));
		model.addAttribute("typeOptions", options);
		
		List<String> radios = new LinkedList<>(Arrays.asList(
				new String[] {"Hours","Piece","Tons"}));
		model.addAttribute("radioOptions", radios);
		
	List<String> checks = new LinkedList<>(Arrays.asList(
				new String[] {"Lead Time", "Special Rate", "Requires Approval"}));
		model.addAttribute("checkOptions", checks);		*/
		//model.addAttribute("resource", new Resource());
		//if(1==1){
		//	throw new RuntimeException("There was an exception");
		//}
		
		return "resource_add";
	}
	
/*	@RequestMapping("/{resourceId}")
	@ResponseBody()
	public Resource findResource(@PathVariable("resourceId") Long resourceId){
		return service.find(resourceId);
	}*/
	
	@RequestMapping("/{resourceId}")
	@ResponseBody()
	public Resource findResource(@PathVariable("resourceId") Resource resource){
		return resource;
	}
	
	@RequestMapping("/find")
	public String find(Model model){
		model.addAttribute("resources", service.findAll());
		return "resources";
	}	
	
/*	@ExceptionHandler(Exception.class)
	public String handlerError(HttpServletRequest request){
		return "controller_error";
	}*/
	
/*	@ExceptionHandler(NullPointerException.class)
	public String handlerError(HttpServletRequest request){
		return "controller_error";
	}	
*/	
/*	@RequestMapping("/request")
	@ResponseBody
	public String request(@ModelAttribute("resource") Resource resource){
		return "The resquest has been sent for approval";
	}*/
	
	
	@RequestMapping("/request")
	@ResponseBody
	public String request(@RequestBody String resource){
		System.out.println(resource);
		return "The resquest has been sent for approval";
	}	
	
	@ModelAttribute("resource")
	public Resource getResources(){
		System.out.println("Adding a new resource to the model");
		return new Resource();
	}	
	
	@ModelAttribute("typeOptions")
	public List<String> getTypes(){
		return new LinkedList<>(Arrays.asList(
				new String[] {"Material","Other","Staff","Technical Equipment"}));
	}
	
	@ModelAttribute("radioOptions")
	public List<String> getRadios(){
		return new LinkedList<>(Arrays.asList(
				new String[] {"Hours","Piece","Tons"}));
	}
	
	@ModelAttribute("checkOptions")
	public List<String> getChecks(){
		return new LinkedList<>(Arrays.asList(
				new String[] {"Lead Time", "Special Rate", "Requires Approval"}));
	}
	
	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource){
		System.out.println("Invoking review");
		return "resource_review";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource, SessionStatus status){
		System.out.println("Invoking save()");
		System.out.println(resource);
		status.setComplete();//Clean the session
		return "redirect:/resource/add";
	
	}	
}
