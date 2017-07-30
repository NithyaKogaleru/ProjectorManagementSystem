package com.leantaas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leantaas.model.Projector;
import com.leantaas.services.IProjectorService;

@RestController
@RequestMapping("/projectors")
public class ProjectorController {

	@Autowired
	IProjectorService projectorService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Projector> getAllProjectors() {
		return projectorService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Projector getProjectorById(@PathVariable(value = "id") Long id) {
		return projectorService.getById(id);
	}
}
