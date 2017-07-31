package com.leantaas.services;

import java.util.List;

import com.leantaas.model.Projector;

/**
 * @author Nithya Kogaleru Interface for Projector data services.
 *
 */
public interface IProjectorService {

	/**
	 * Service to get all projector details from the repository.
	 * 
	 * @return list of all projector details.
	 */
	List<Projector> getAll();

	/**
	 * Service to get team details based on team id from repository.
	 * 
	 * @param id
	 *            team id
	 * @return team details
	 */
	Projector getById(Long id);
}
