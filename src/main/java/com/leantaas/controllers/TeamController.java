package com.leantaas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leantaas.model.Team;
import com.leantaas.services.ITeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	ITeamService teamService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Team> getAllTeams() {
		return teamService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Team getTeamById(@PathVariable(value = "id") Long id) {
		return teamService.getById(id);
	}
}
