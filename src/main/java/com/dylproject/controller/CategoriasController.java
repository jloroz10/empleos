package com.dylproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dylproject.model.Categoria;
import com.dylproject.service.ICategoriasService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	@Autowired
	private ICategoriasService serviceCategorias;
	
	// @GetMapping("/index")
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
	List<Categoria> categorias = serviceCategorias.buscarTodas();
	
	model.addAttribute("categorias", categorias);
	return "categorias/listCategorias";
	}
	
	//@RequestMapping(value="/create", method=RequestMethod.GET)
	 @GetMapping("/create")
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	// @PostMapping("/save")
//	@RequestMapping(value="/save", method=RequestMethod.POST)
//	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
//		
//		System.out.println("categoria: "+nombre);
//		System.out.println("descripcion: "+descripcion);
//		return "categorias/listCategorias";
//	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Categoria categoria,BindingResult results , RedirectAttributes attributes) {
		
		if(results.hasErrors()) {
			return "/categorias/formCategoria";
		}
		
		categoria.setId(serviceCategorias.siguienteId());
		System.out.println(categoria);
		
		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "Categoria creada correctamente!");
		return "redirect:/categorias/index";
	}
}
