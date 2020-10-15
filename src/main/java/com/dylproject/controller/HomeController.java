package com.dylproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dylproject.model.Vacante;

@Controller
public class HomeController {

	@GetMapping("/vacantes")
	public String getOfertas(Model model) {
		List<Vacante> vacantes = new ArrayList<Vacante>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
	try {
		Vacante v1 = new Vacante();
		
		v1.setId(1);
		v1.setNombre("Ingeniero en Computacion");
		v1.setDescripcion("Se requiere ingeniero fullstack");
		v1.setFechaPub(sdf.parse("12-10-2020"));
		v1.setSalario(15000.0);
		v1.setDestacado(1);
		v1.setImagen("empresa1.png");
		
		Vacante v2 = new Vacante();
		
		v2.setId(2);
		v2.setNombre("Ingeniero en Informatica");
		v2.setDescripcion("Se requiere que tenga experiencia paqueria Office");
		v2.setFechaPub(sdf.parse("08-10-2020"));
		v2.setSalario(8000.0);
		v2.setDestacado(0);
		
		Vacante v3 = new Vacante();
		
		v3.setId(3);
		v3.setNombre("Licenciado en Mercadotecnia");
		v3.setDescripcion("Se requiere manejo de redes sociales");
		v3.setFechaPub(sdf.parse("09-10-2020"));
		v3.setSalario(10000.0);
		v3.setDestacado(1);
		v3.setImagen("empresa3.png");
		
		Vacante v4 = new Vacante();
		
		v4.setId(4);
		v4.setNombre("auxiliar de Cocina");
		v4.setDescripcion("Se requiere para restaurante Japones");
		v4.setFechaPub(sdf.parse("10-10-2020"));
		v4.setSalario(9000.0);
		v4.setDestacado(1);
		v4.setImagen("empresa4.png");
		
		Vacante v5 = new Vacante();
		
		v5.setId(5);
		v5.setNombre("Maquillista");
		v5.setDescripcion("Manejo de efectos");
		v5.setFechaPub(sdf.parse("11-10-2020"));
		v5.setSalario(6000.0);
		v5.setDestacado(0);
		
		vacantes.add(v1);
		vacantes.add(v2);
		vacantes.add(v3);
		vacantes.add(v4);
		vacantes.add(v5);
		
		model.addAttribute("vacantes", vacantes);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return "vacantes";
	}
	
	@GetMapping("/detalle")
	public String getDetails(Model model) {
		Vacante e = new Vacante();
		
		e.setNombre("Ingeniero en Computacion");
		e.setDescripcion("Se requiere ingeniero fullstack");
		e.setFechaPub(new Date());
		e.setSalario(15000.0);
		
		model.addAttribute("empleo", e);
		return "detalle";
	}
	@GetMapping("/listado")
	public String getList(Model model) {
		
		List<String> lista = new LinkedList<String>();
		
		lista.add("Ingeniero en Computacion");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		lista.add("Mercadologo");
		
		model.addAttribute("empleos",lista);
		
		return "lista";
	}
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		
		model.addAttribute("message", "Welcome to Empleos App");
		model.addAttribute("name", "Luis");
		model.addAttribute("date",new Date());
		
		
		return "home"; //home is the name of the template (home.html) saved in src/main/resources/templates
	}
}
