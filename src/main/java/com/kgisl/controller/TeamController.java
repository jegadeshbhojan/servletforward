package com.kgisl.controller;

import java.util.List;

import com.kgisl.entity.Team;
import com.kgisl.repository.TeamRepository;

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
 * TeamController
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;
    
    @RequestMapping(method=RequestMethod.POST)
	public Team create(@RequestBody Team team)
	{
    	team.setTeamid(0L);
		return teamRepository.saveAndFlush(team);
	}
    
    @RequestMapping(value="{id}",method=RequestMethod.PUT)
	public Team update(@PathVariable Long id, @RequestBody Team updatedteam)
	{	
		Team team = teamRepository.getOne(id);
		team.setTeamname(updatedteam.getTeamname());
	    return teamRepository.saveAndFlush(team);
	}
 
    @RequestMapping(method=RequestMethod.GET)
    List<Team> read() {
        return teamRepository.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {
    	teamRepository.deleteById(id);
    }
    
}