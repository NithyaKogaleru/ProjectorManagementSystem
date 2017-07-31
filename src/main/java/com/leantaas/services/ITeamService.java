package com.leantaas.services;

import java.util.List;

import com.leantaas.model.Team;

/**
 * @author Nithya Kogaleru Interface for team data services.
 *
 */
public interface ITeamService {

	/**
	 * Service to get all teams details from the repository.
	 * 
	 * @return list of all team details.
	 */
	List<Team> getAll();

	/**
	 * Service to get team details based on team id from repository.
	 * 
	 * @param id
	 *            team id
	 * @return team details
	 */
	Team getById(Long id);
}
