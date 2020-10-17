package com.dylproject.service;

import java.util.List;

import com.dylproject.model.Categoria;

public interface ICategoriasService {
	public void guardar(Categoria categoria);
	public List<Categoria> buscarTodas();
	public Categoria buscarPorId(int idCategoria);
	public int siguienteId();
}
