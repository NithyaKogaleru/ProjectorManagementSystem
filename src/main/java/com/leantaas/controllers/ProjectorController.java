package com.leantaas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leantaas.model.Projector;
import com.leantaas.services.IProjectorService;

/**
 * @author Nithya Kogaleru Rest Controller for Projector Data services.
 */
@RestController
@RequestMapping("/projectors")
public class ProjectorController {

	@Autowired
	IProjectorService projectorService;

	/**
	 * rest controller to get list of projectors using GET API call '/projectors/'.
	 * 
	 * @return List of projectors.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Projector> getAllProjectors() {
		return projectorService.getAll();
	}

	/**
	 * rest controller to get projector details based on id using GET API call
	 * '/projectors' '/projectors/{id}'.
	 * 
	 * @param id
	 *            id for which the projector details is requested.
	 * @return Projector details.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Projector getProjectorById(@PathVariable(value = "id") Long id) {
		return projectorService.getById(id);
	}
}
