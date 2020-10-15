package com.dylproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dylproject.model.Vacante;
import com.dylproject.service.IVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	public IVacantesService serviceVacantes;

	@GetMapping("/vacantes")
	public String getOfertas(Model model) {
		
		List<Vacante> vacantes = serviceVacantes.getVacantes();
		model.addAttribute("vacantes", vacantes);

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
