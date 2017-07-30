package com.leantaas.services;

import java.util.List;

import com.leantaas.model.Projector;

public interface IProjectorService {

	List<Projector> getAll();

	Projector getById(Long id);
}
