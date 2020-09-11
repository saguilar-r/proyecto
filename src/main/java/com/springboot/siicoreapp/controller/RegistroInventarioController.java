package com.springboot.siicoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.siicoreapp.models.entity.RegistroInventario;

import com.springboot.siicoreapp.models.service.IRegistroInventarioService;

import com.springboot.siicoreapp.models.service.ITerceroService;

@Controller
@RequestMapping("/stock")
public class RegistroInventarioController {
	
	@Autowired
	private IRegistroInventarioService registroInventarioService;
	
	@Autowired
	private ITerceroService terceroService;
	
	@GetMapping("/")
	public String listarTodos(Model model) {
		
		model.addAttribute("titulo", "STOCK MODULE");
		model.addAttribute("stock", registroInventarioService.listarTodos());
		
		return "/views/stock/listaStock";
	}
	
	@GetMapping("/createStock")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New");
		model.addAttribute("stock", new RegistroInventario());
		model.addAttribute("terceros", terceroService.listarTodos());
		
		return "/views/stock/frmStock";
	}
	
	@PostMapping("/saveStock")
	public String guardar(@ModelAttribute RegistroInventario registroInventario, Model model, RedirectAttributes attr) {
		
		registroInventarioService.guardar(registroInventario);
		attr.addFlashAttribute("success", "Record saved successfully");
		model.addAttribute("terceros", terceroService.listarTodos());
		
		return "redirect:/stock/";
	}

	@GetMapping("/edit/{id_registro_inventario}")
	public String editar (@PathVariable ("id_registro_inventario") Long idRegistroInventario, Model model) {
		
		model.addAttribute("titulo", "Form: Edit Sale");
		model.addAttribute("stock", registroInventarioService.buscarPorId(idRegistroInventario));
		model.addAttribute("terceros", terceroService.listarTodos());
		
		return "/views/stock/frmStock";
	}
	
	@GetMapping("/delete/{id_registro_inventario}")
	public String eliminar(@PathVariable("id_registro_inventario")Long idRegistroInventario, RedirectAttributes attr) {
		
		registroInventarioService.eliminar(idRegistroInventario);
		attr.addFlashAttribute("warning", "Record was delete");
		
		return "redirect:/stock/";
	}
}

