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

import com.springboot.siicoreapp.models.entity.RegistroCompra;
import com.springboot.siicoreapp.models.service.IRegistroCompraService;
import com.springboot.siicoreapp.models.service.ITerceroService;


@Controller
@RequestMapping("/compras")
public class RegistroCompraController {
	
	@Autowired
	private IRegistroCompraService registroCompraService;
	
	@Autowired
	private ITerceroService terceroService;
	
	@GetMapping("/")
	public String listarTodos(Model model) {
		
		model.addAttribute("titulo", "PURCHASE MODULE");
		model.addAttribute("compra", registroCompraService.listaTodos());
		
		return "/views/compras/listarCompras";
	}
	
	@GetMapping("/createcompra")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Purchase");
		model.addAttribute("compra", new RegistroCompra());
		model.addAttribute("tercero", terceroService.listarTodos());
		
		return "/views/compras/frmCompras";
	}
	
	@PostMapping("/savecompra")
	public String guardar(@ModelAttribute RegistroCompra registroCompra, Model model, RedirectAttributes attr) {
		
		registroCompraService.guardar(registroCompra);
		attr.addFlashAttribute("success", "Record saved successfully");
		model.addAttribute("tercero", terceroService.listarTodos());
		
		return "redirect:/compras/";
	}
	
	@GetMapping("/edit/{id_registro_compra}")
	public String editar(@PathVariable ("id_registro_compra") Long idRegistroCompra, Model model) {
		
		model.addAttribute("titulo", "Form: Edit Purchase");
		model.addAttribute("compra", registroCompraService.buscarPorId(idRegistroCompra));
		model.addAttribute("tercero", terceroService.listarTodos());
		
		return "/views/compras/frmCompras";
	}
	
	public String eliminar(@PathVariable("id_registro_compra") Long idRegistroCompra, RedirectAttributes attr) {
		
		registroCompraService.eliminar(idRegistroCompra);
		attr.addFlashAttribute("warning", "Record was delete successfully!");
		
		return "redirect:/compras/";
	}

}
