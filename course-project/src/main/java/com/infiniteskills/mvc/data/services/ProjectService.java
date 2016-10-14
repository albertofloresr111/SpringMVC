package com.infiniteskills.mvc.data.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.entities.Sponsor;

public class ProjectService {

		private List<Project> projects = new ArrayList<Project>();
		
		public ProjectService(){
			Project javaProject = this.createProject((long) 1,"Java Project", "This is a Java Project", new Sponsor("Oracle", "555-555-5555", "oracle@oracle.com"));
			this.projects.add(javaProject);
			
			Project javascriptProject = this.createProject((long)2,"Javascript Project", "This is a Javascript Project", new Sponsor("Mozilla", "555-555-5555", "mozilla@mozilla.com"));
			this.projects.add(javascriptProject);
			
			Project htmlProject = this.createProject((long)3,"HTML Project", "This is an HTML project", new Sponsor("Google", "555-555-5555", "google@google.com"));
			this.projects.add(htmlProject);
		}
		
		public List<Project> findAll(){
			return this.projects;
		}
	
		public Project find(Long projectId){
			return this.projects.stream().filter(p -> {
				return p.getProjectId().equals(projectId);
			}).collect(Collectors.toList()).get((0));
		}
		
		public void save(Project project){
			this.projects.add(project);
		}

		private Project createProject(Long projectId, String title, String description, Sponsor sponsor) {
			Project project = new Project();
			project.setProjectId(projectId);
			project.setName(title);
			project.setAuthorizedFunds(new BigDecimal("100000"));
			project.setAuthorizedHours(new BigDecimal("1000"));
			project.setSpecial(false);
			project.setType("multi");
			project.setYear("2015");
			project.setDescription(description);
			project.setSponsor(sponsor);
			return project;
		}
		
}
