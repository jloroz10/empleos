package com.dylproject.service;

import java.util.ArrayList;
import java.util.List;

import com.dylproject.model.Categoria;

public class CategoriasServiceImpl implements ICategoriasService{

	List<Categoria> categorias;
	
	public CategoriasServiceImpl() {
		this.categorias = new ArrayList<Categoria>();
	}
	
	@Override
	public void guardar(Categoria categoria) {
		this.categorias.add(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodas() {
		
		return categorias;
	}

	@Override
	public Categoria buscarPorId(int idCategoria) {
		for(Categoria c : categorias) {
			if(c.getId() == idCategoria ) {
				return c;
			}
		}
		
		return null;
	}

}
