package com.dylproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dylproject.model.Vacante;
import com.dylproject.service.ICategoriasService;
import com.dylproject.service.IVacantesService;
import com.dylproject.util.Utileria;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService serviceVacante;
	@Autowired
	private ICategoriasService serviceCategorias;
	
	@GetMapping("/create")
	public String crear(Vacante vacante, Model modelo){
		
		modelo.addAttribute("categorias", serviceCategorias.buscarTodas());
		return "/vacantes/formVacante";
	}
	
//	@PostMapping("/save")
//	public String guardar(@RequestParam("nombre") String nombre ,@RequestParam("descripcion") String descripcion ,
//			@RequestParam("estatus") String estatus,@RequestParam("fecha") String fecha,
//			@RequestParam("destacado") int destacado, @RequestParam("salario") double salario,@RequestParam("detalles") String detalles) {
//		
//		System.out.println("Nombre: "+nombre);
//		System.out.println("Descripcion: "+descripcion);
//		System.out.println("Estatus: "+estatus);
//		System.out.println("Fecha: "+fecha);
//		System.out.println("Destacado: "+destacado);
//		System.out.println("Salario: "+salario);
//		System.out.println("Detalles: "+detalles);
//		
//		return "/vacantes/listVacantes";
//	}
	
	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes,@RequestParam("archivoImagen") MultipartFile multiPart) {
		
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("error: "+error.getDefaultMessage());
			}
			System.out.println(vacante);
			return "/vacantes/formVacante";
		}
		
		vacante.setId(serviceVacante.getNextId());
		
		if (!multiPart.isEmpty()) {
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
//			String ruta = "D:/files/projects/spring/empleos/src/main/resources/static/img/"; // Windows
			String ruta = "D:/files/projects/empleos/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
			// Procesamos la variable nombreImagen
			vacante.setImagen(nombreImagen);
			}
		}

		attributes.addFlashAttribute("msg", "Vacante creata correctamente!");
		serviceVacante.guardarVacante(vacante);
		System.out.println(vacante);
		
		//to internally execute a get request to vacantes/index
		return "redirect:/vacantes/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		List<Vacante> lista = serviceVacante.getVacantes();
		model.addAttribute("vacantes", lista);
		
		return "/vacantes/listVacantes";
	}
	
	@GetMapping("/view/{id}")
	public String getDetails(@PathVariable("id") int id, Model model) {
		System.out.println("IdVacante: "+ id);
		
		Vacante v = serviceVacante.getVacanteById(id);
		//get the data from database from id
		
		model.addAttribute("vacante", v);
		
		return "vacantes/detalle";
	}
	
	@GetMapping("/delete")
	public String deleteVacante(@RequestParam("id") int idVacante,Model model,RedirectAttributes attributes) {
		
		System.out.println("Borrando vacante con id: "+idVacante);
		
		serviceVacante.deleteVacantebyId(idVacante);
		attributes.addFlashAttribute("msgDelete", "Vacante eliminada correctamente!");
		return "redirect:/vacantes/index";
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
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
