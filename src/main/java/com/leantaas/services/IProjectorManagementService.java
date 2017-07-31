package com.leantaas.services;

import java.util.Date;
import java.util.List;

import com.leantaas.model.ProjectorManagement;
import com.leantaas.model.Reservation;

/**
 * @author Nithya Kogaleru Interface for projector reservation management
 *         service.
 *
 */
public interface IProjectorManagementService {

	/**
	 * service that gets all reservations that are active from the repository
	 * 
	 * @return list of all active reservations
	 */
	List<ProjectorManagement> getAllReservations();

	/**
	 * Service to add new reservation on availability. returns null projector if
	 * unavailable.
	 * 
	 * @param projectorManagement
	 *            details of reservation including start time, end time and team
	 *            details.
	 * @return details of availability and projector if successful else null in
	 *         projector details.
	 */
	ProjectorManagement addReservation(ProjectorManagement projectorManagement);

	/**
	 * Service to cancel an existing request
	 * 
	 * @param id
	 *            id of the request that has to be canceled.
	 * @return canceled reservation.
	 */
	ProjectorManagement cancelReservation(Long id);

	/**
	 * Service check for projector availability during the given time slot
	 * 
	 * @param startTime
	 *            start of time slot
	 * @param endTime
	 *            end of time slot
	 * @return returns projector details and availability as true if available
	 */
	Reservation checkAvailability(Date startTime, Date endTime);

	/**
	 * Service to get reservations of a particular team.
	 * 
	 * @param id
	 *            team id
	 * @return list of reservations made by particular team.
	 */
	List<ProjectorManagement> getReservationByTeam(Long id);
}
