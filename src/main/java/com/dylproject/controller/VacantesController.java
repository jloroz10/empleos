package com.dylproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {

	@GetMapping("/view/{id}")
	public String getDetails(@PathVariable("id") int idVacante, Model model) {
		System.out.println("IdVacante: "+ idVacante);
		
		//get the data from database from id
		model.addAttribute("idVacante", idVacante);
		
		return "vacantes/detalle";
	}
	
	@GetMapping("/delete")
	public String deleteVacante(@RequestParam("id") int idVacante,Model model) {
		
		System.out.println("Borrando vacante con id: "+idVacante);
		String mensaje = "Vacante con id "+idVacante+" fue eliminado correctamente";
		model.addAttribute("mensaje", mensaje);
		return "mensaje";
	}
}
