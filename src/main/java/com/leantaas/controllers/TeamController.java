package com.leantaas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leantaas.exceptions.NoDataFoundException;
import com.leantaas.model.Team;
import com.leantaas.services.ITeamService;

/**
 * @author Nithya Kogaleru Rest Controller for Team data services.
 *
 */
@RestController
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	ITeamService teamService;

	/**
	 * rest controller to get list of teams using GET API call '/teams/'.
	 * 
	 * @return List of teams.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Team> getAllTeams() {
		List<Team> teams = teamService.getAll();

		if (teams == null || teams.size() == 0) {
			throw new NoDataFoundException();
		}

		return teams;
	}

	/**
	 * rest controller to get team details based on id using GET API call
	 * '/projectors' '/teams/{id}'.
	 * 
	 * @param id
	 *            id for which the team details is requested.
	 * @return team details.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Team getTeamById(@PathVariable(value = "id") Long id) {
		Team team = teamService.getById(id);

		if (team == null) {
			throw new NoDataFoundException();
		}

		return team;
	}
}
