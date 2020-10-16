package com.dylproject.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dylproject.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService{

	List<Vacante> vacantes;

    
	public VacantesServiceImpl() {
		
		this.vacantes = new ArrayList<Vacante>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		

		try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Ingeniero en Computacion");
			v1.setDescripcion("Se requiere ingeniero fullstack");
			v1.setFecha(sdf.parse("12-10-2020"));
			v1.setSalario(13000.0);
			v1.setDestacado(1);
			v1.setImagen("empresa1.png");
			
			Vacante v2 = new Vacante();
			
			v2.setId(2);
			v2.setNombre("Ingeniero en Informatica");
			v2.setDescripcion("Se requiere que tenga experiencia paqueria Office");
			v2.setFecha(sdf.parse("08-10-2020"));
			v2.setSalario(8000.0);
			v2.setDestacado(0);
			
			Vacante v3 = new Vacante();
			
			v3.setId(3);
			v3.setNombre("Licenciado en Mercadotecnia");
			v3.setDescripcion("Se requiere manejo de redes sociales");
			v3.setFecha(sdf.parse("09-10-2020"));
			v3.setSalario(10000.0);
			v3.setDestacado(1);
			v3.setImagen("empresa3.png");
			
			Vacante v4 = new Vacante();
			
			v4.setId(4);
			v4.setNombre("auxiliar de Cocina");
			v4.setDescripcion("Se requiere para restaurante Japones");
			v4.setFecha(sdf.parse("10-10-2020"));
			v4.setSalario(9000.0);
			v4.setDestacado(1);
			v4.setImagen("empresa4.png");
			
			Vacante v5 = new Vacante();
			
			v5.setId(5);
			v5.setNombre("Maquillista");
			v5.setDescripcion("Manejo de efectos");
			v5.setFecha(sdf.parse("11-10-2020"));
			v5.setSalario(6000.0);
			v5.setDestacado(0);
			
			vacantes.add(v1);
			vacantes.add(v2);
			vacantes.add(v3);
			vacantes.add(v4);
			vacantes.add(v5);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Vacante> getVacantes() {
		
		return vacantes;
	}
	
	
	public Vacante getVacanteById(int id){
		
		for(Vacante v:vacantes){
			if(v.getId()==id){
				return v;
			}
		}
		return null;
	}

	@Override
	public void guardarVacante(Vacante v) {
		vacantes.add(v);
		
	}

}
