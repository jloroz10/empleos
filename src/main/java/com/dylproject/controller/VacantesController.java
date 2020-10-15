package com.dylproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dylproject.model.Vacante;
import com.dylproject.service.IVacantesService;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService serviceVacante;

	@GetMapping("/view/{id}")
	public String getDetails(@PathVariable("id") int id, Model model) {
		System.out.println("IdVacante: "+ id);
		
		Vacante v = serviceVacante.getVacanteById(id);
		//get the data from database from id
		
		model.addAttribute("vacante", v);
		
		return "vacantes/detalle";
	}
	
	@GetMapping("/delete")
	public String deleteVacante(@RequestParam("id") int idVacante,Model model) {
		
		System.out.println("Borrando vacante con id: "+idVacante);
		String mensaje = "Vacante con id "+idVacante+" fue eliminado correctamente";
		model.addAttribute("mensaje", mensaje);
		return "mensaje";
	}
	
	@GetMapping("/edit")
	public String getVacanteById(@RequestParam("id") int id,Model model) {
		
		Vacante v = serviceVacante.getVacanteById(id);
				
		model.addAttribute("vacante", v);
		
		return "vacantes/vacante_edit";
	}
	
	@PostMapping("/update")
	public String updateVacante(@RequestParam("id") int id,@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,Model model) {
		
		Vacante vacante = serviceVacante.getVacanteById(id);
		
		
		System.out.println("Vacante: "+nombre);
		System.out.println("Descripcion: "+descripcion);
		
		vacante.setNombre(nombre);
		vacante.setDescripcion(descripcion);
		
		List<Vacante> vacantes = serviceVacante.getVacantes();
		model.addAttribute("vacantes", vacantes);
		return "vacantes";
	}
	
	
}