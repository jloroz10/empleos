package com.dylproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dylproject.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService{

	List<Categoria> categorias;
	
	public CategoriasServiceImpl() {
		this.categorias = new ArrayList<Categoria>();
		
		this.categorias.add(new Categoria(1,"Recursos Humanos","Trabajos relacionados con el area de RH."));
		this.categorias.add(new Categoria(2,"Ventas","Ofertas de trabajo relacionado con ventas."));
		this.categorias.add(new Categoria(3,"Arquitectura","Diseño de planos en general y trabajos relacionados."));
//		this.categorias.add(new Categoria(1,1,"Trabajos relacionados con el area de RH."));
//		this.categorias.add(new Categoria(2,2,"Ofertas de trabajo relacionado con ventas."));
//		this.categorias.add(new Categoria(3,2,"Diseño de planos en general y trabajos relacionados."));

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


	@Override
	public int siguienteId() {
		return categorias.size()+1;
	}

}
