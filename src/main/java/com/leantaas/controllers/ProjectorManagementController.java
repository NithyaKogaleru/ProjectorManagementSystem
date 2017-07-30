package com.leantaas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leantaas.model.ProjectorManagement;
import com.leantaas.services.IProjectorManagementService;

@RestController
@RequestMapping("/projector-management")
public class ProjectorManagementController {

	@Autowired
	IProjectorManagementService projectorManagementService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ProjectorManagement> getAllProjectorManagements() {
		return projectorManagementService.getAll();
	}
}
