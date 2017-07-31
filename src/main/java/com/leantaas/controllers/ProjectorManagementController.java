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

import com.leantaas.exceptions.NoDataFoundException;
import com.leantaas.model.ProjectorManagement;
import com.leantaas.model.Reservation;
import com.leantaas.services.IProjectorManagementService;

/**
 * @author Nithya Kogaleru Rest Controller for Projector reservation management
 *         services.
 *
 */
@RestController
@RequestMapping("/reservations")
public class ProjectorManagementController {

	@Autowired
	IProjectorManagementService projectorManagementService;

	/**
	 * Gets all active reservation made using GET API call '/reservations/'.
	 * 
	 * @return List of all active reservations.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ProjectorManagement> getAllReservations() {
		List<ProjectorManagement> reservations = projectorManagementService.getAllReservations();
		
		if(reservations == null || reservations.size() == 0) {
			throw new NoDataFoundException();
		}
		
		return reservations;
	}

	/**
	 * To request a reservation providing the time slot and team name in the request
	 * body using POST API call '/reservations/'
	 * 
	 * @param projectorManagement
	 *            Reservation details
	 * @return updated reservation details gives projector details on availability
	 *         or has projector as null if not available
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ProjectorManagement addReservation(@RequestBody ProjectorManagement projectorManagement) {
		return projectorManagementService.addReservation(projectorManagement);
	}

	/**
	 * To get all the reservations made by a particular team using GET API call
	 * /reservations/team/{id}'
	 * 
	 * @param id
	 *            team id
	 * @return list of reservations made by particular team.
	 */
	@RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
	public List<ProjectorManagement> getReservationByTeam(@PathVariable(value = "id") Long id) {
		List<ProjectorManagement> reservationsByTeam = projectorManagementService.getReservationByTeam(id);
		
		if(reservationsByTeam == null || reservationsByTeam.size() == 0) {
			throw new NoDataFoundException();
		}
		
		return reservationsByTeam;
	}

	/**
	 * Cancel an existing reservation using PATCH API call
	 * '/reservations/cancel/{id}'
	 * 
	 * @param id
	 *            id of the reservation that has to be cancelled.
	 * @return canceled reservation details.
	 */
	@RequestMapping(value = "/cancel/{id}", method = RequestMethod.PATCH)
	public ProjectorManagement cancelReservation(@PathVariable(value = "id") Long id) {
		return projectorManagementService.cancelReservation(id);
	}

	/**
	 * Check availability of projector using GET API call
	 * '/reservations/availability/{startDate}/{endDate}'
	 * 
	 * @param startDate
	 *            starting time slot
	 * @param endDate
	 *            ending time slot
	 * @return returns data containing availability and projector details if
	 *         available
	 */
	@RequestMapping(value = "/availability/{startTime}/{endTime}", method = RequestMethod.GET)
	public Reservation isProjectorAvailable(
			@PathVariable(value = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX") Date startTime,
			@PathVariable(value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX") Date endTime) {
		return projectorManagementService.checkAvailability(startTime, endTime);
	}
}
