package com.springboot.siicoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.siicoreapp.models.entity.Tercero;
import com.springboot.siicoreapp.models.service.ICategoriaTercero;
import com.springboot.siicoreapp.models.service.ITerceroService;


@Controller
@RequestMapping("/terceros")
public class TerceroController {
	
	@Autowired
	private ITerceroService terceroService;
	
	@Autowired
	private ICategoriaTercero categoriaTerceroService;
	
	@Secured({"ROLE_ADMIN","ROLE_VENDEDOR","ROLE_AUXILIAR"})
	@GetMapping("/")
	public String listarTodos(Model model) {
		
		model.addAttribute("titulo", "TERCEROS");
		model.addAttribute("terceros", terceroService.listarTodos());
		
		return "/views/terceros/listarTerceros";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/createTercero")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Third Parties");
		model.addAttribute("terceros", new Tercero());
		model.addAttribute("cterceros", categoriaTerceroService.listarTodos());
		
		return "/views/terceros/frmTerceros";
	}
	@Secured({"ROLE_ADMIN","ROLE_VENDEDOR","ROLE_AUXILIAR"})
	@PostMapping("/saveTercero")
	public String guardar(@ModelAttribute Tercero tercero, Model model, RedirectAttributes attr) {
		
		terceroService.guardar(tercero);
		attr.addFlashAttribute("success", "Record saved successfully");
		model.addAttribute("cterceros", categoriaTerceroService.listarTodos());
		
		return "redirect:/terceros/";
	}
	
	@Secured({"ROLE_ADMIN","ROLE_VENDEDOR","ROLE_AUXILIAR"})
	@GetMapping("/edit/{id_tercero}")
	public String editar(@PathVariable ("id_tercero") Long idTercero, Model model) {
		
		model.addAttribute("titulo", "Form: Edit Third Parties");
		model.addAttribute("terceros", terceroService.buscarPorId(idTercero));
		model.addAttribute("cterceros", categoriaTerceroService.listarTodos());
		
		return "/views/terceros/frmTerceros";
	}
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/delete/{id_tercero}")
	public String eliminar(@PathVariable("id_tercero")Long idTercero, Model model, RedirectAttributes attr) {
		
		terceroService.eliminar(idTercero);
		attr.addFlashAttribute("warning", "Record was delete");
		
		return "redirect:/terceros/";
	}

}
