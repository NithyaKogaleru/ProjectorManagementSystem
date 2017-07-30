package com.leantaas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Projector> getAllProjectors(){
		return projectorService.getAll();
	}
}
