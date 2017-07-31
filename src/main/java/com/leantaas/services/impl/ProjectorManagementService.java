package com.leantaas.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantaas.model.Projector;
import com.leantaas.model.ProjectorManagement;
import com.leantaas.model.Reservation;
import com.leantaas.repository.IProjectorManagementRepository;
import com.leantaas.repository.IProjectorRepository;
import com.leantaas.services.IProjectorManagementService;

@Service
public class ProjectorManagementService implements IProjectorManagementService {

	@Autowired
	IProjectorManagementRepository projectorManagementRepository;

	@Autowired
	IProjectorRepository projectorRepository;

	@Override
	public List<ProjectorManagement> getAllReservations() {
		return projectorManagementRepository.findAll();
	}

	@Override
	public ProjectorManagement addReservation(ProjectorManagement projectorManagement) {
		Reservation reservation = checkAvailability(projectorManagement.getStartTime(), projectorManagement.getEndTime());
		if(reservation.isAvailable()) {
			projectorManagement.setProjector(reservation.getProjector());
			return projectorManagementRepository.save(projectorManagement);
		}
		else{
			projectorManagement.setActive(false);
		}
		return projectorManagement;
	}

	@Override
	public ProjectorManagement cancelReservation(Long id) {
		ProjectorManagement toUpdate = projectorManagementRepository.getOne(id);
		toUpdate.setActive(false);
		return projectorManagementRepository.save(toUpdate);
	}

	@Override
	public Reservation checkAvailability(Date startTime, Date endTime) {
		Reservation reservation = new Reservation();
		Projector availableProjector = projectorManagementRepository.findAvailableProjector(startTime, endTime);
		if(availableProjector != null) {
			reservation.setAvailable(true);
			reservation.setProjector(availableProjector);
			reservation.setStartTime(startTime);
			reservation.setEndTime(endTime);
		}
		
		return reservation;
	}
}
