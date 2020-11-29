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

import com.springboot.siicoreapp.models.entity.CategoriaTercero;
import com.springboot.siicoreapp.models.service.ICategoriaTercero;

@Controller
@RequestMapping("/cterceros")
public class CategoriaTerceroController {
	
	@Autowired
	private ICategoriaTercero categoriaTerceroService;
	
	@Secured({"ROLE_VENDEDOR", "ROLE_ADMIN"})
	@GetMapping("/")
	public String listarTodos(Model model) {
		model.addAttribute("titulo", "CATEGORIA TERCERO");
		model.addAttribute("cterceros", categoriaTerceroService.listarTodos());
		
		return "/views/cterceros/listaCTerceros";
	}

	@Secured({"ROLE_VENDEDOR", "ROLE_ADMIN"})
	@GetMapping("/createcterceros")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Third Partie Category");
		model.addAttribute("cterceros", new CategoriaTercero());
		
		return "/views/cterceros/frmCTerceros";
	}
	
	@Secured({"ROLE_VENDEDOR", "ROLE_ADMIN"})
	@PostMapping("/savecterceros")
	public String guardar(@ModelAttribute CategoriaTercero categoriaTercero, Model model, RedirectAttributes attr) {
		
		categoriaTerceroService.guardar(categoriaTercero);
		attr.addFlashAttribute("success", "Record was save successfully");
		
		return "redirect:/cterceros/";
	}
	
	@Secured({"ROLE_VENDEDOR", "ROLE_ADMIN"})
	@GetMapping("/edit/{id_categoria_tercero}")
	public String editar(@PathVariable ("id_categoria_tercero") Long idCategoriaTercero, Model model) {
		
		model.addAttribute("titulo", "Form: Product Category Edit");
		model.addAttribute("cterceros", categoriaTerceroService.buscarPorId(idCategoriaTercero));
		
		return "/views/cterceros/frmCTerceros";
		
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id_categoria_tercero}")
	public String eliminar(@PathVariable ("id_categoria_tercero") Long idCategoriaTercero, Model model, RedirectAttributes attr) {
		
		categoriaTerceroService.eliminar(idCategoriaTercero);
		attr.addFlashAttribute("warning", "Record was delete successfully!");
		
		return "redirect:/cterceros/";
}
}