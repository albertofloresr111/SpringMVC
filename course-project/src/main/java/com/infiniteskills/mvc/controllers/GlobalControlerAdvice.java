package com.infiniteskills.mvc.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;

import com.infiniteskills.mvc.data.validators.ProjectValidator;

@ControllerAdvice(annotations= Controller.class)
public class GlobalControlerAdvice {
	@ModelAttribute("currentDate")
	public Date getCurrentDate(){
		return new Date();
	}
	
	@InitBinder("project")
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProjectValidator());
	} 	

	@ExceptionHandler(NullPointerException.class)
	public String handlerError(HttpServletRequest request){
		return "controller_error";
	}	
	
	

}
