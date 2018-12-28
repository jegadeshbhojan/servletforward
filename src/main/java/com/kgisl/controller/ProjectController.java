package com.kgisl.controller;

import java.util.List;

import com.kgisl.entity.Project;
import com.kgisl.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

/**
 * ProjectController
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @RequestMapping(method=RequestMethod.POST)
	public Project create(@RequestBody Project project)
	{
    	project.setProjectid(0L);
		return projectRepository.saveAndFlush(project);
	}
    
    @RequestMapping(value="{id}",method=RequestMethod.PUT)
	public Project update(@PathVariable Long id, @RequestBody Project updatedproject)
	{	
		Project project = projectRepository.getOne(id);
		project.setProjectname(updatedproject.getProjectname());
	    return projectRepository.saveAndFlush(project);
	}
 
    @RequestMapping(method=RequestMethod.GET)
    List<Project> read() {
        return projectRepository.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {
    	projectRepository.deleteById(id);
    }
    
}