package com.leantaas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantaas.model.Projector;
import com.leantaas.repository.IProjectorRepository;
import com.leantaas.services.IProjectorService;

@Service
public class ProjectorService implements IProjectorService {
	
	@Autowired
	IProjectorRepository projectorRepository;

	@Override
	public List<Projector> getAll() {		
		return projectorRepository.findAll();
	}
}
