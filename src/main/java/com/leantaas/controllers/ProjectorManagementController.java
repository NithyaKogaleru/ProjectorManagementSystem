package com.leantaas.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leantaas.model.ProjectorManagement;
import com.leantaas.model.Reservation;
import com.leantaas.services.IProjectorManagementService;

@RestController
@RequestMapping("/projector-management")
public class ProjectorManagementController {

	@Autowired
	IProjectorManagementService projectorManagementService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ProjectorManagement> getAllReservations() {
		return projectorManagementService.getAllReservations();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ProjectorManagement addReservation(@RequestBody ProjectorManagement projectorManagement) {
		return projectorManagementService.addReservation(projectorManagement);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ProjectorManagement cancelReservation(@PathVariable(value="id") Long id) {
		return projectorManagementService.cancelReservation(id);
	}
	
	@RequestMapping(value = "/availability/{startDate}/{endDate}", method = RequestMethod.GET)
	public Reservation isProjectorAvailable(@PathVariable(value="startDate") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ssX") Date startDate, 
			@PathVariable(value="startDate") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ssX") Date endDate) {
		return projectorManagementService.checkAvailability(startDate, endDate);
	}
}
