package com.dylproject.service;

import java.util.List;

import com.dylproject.model.Vacante;


public interface IVacantesService {
	
	public List<Vacante> getVacantes();
	public Vacante getVacanteById(int id);
}
