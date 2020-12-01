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

import com.springboot.siicoreapp.models.entity.RegistroVenta;
import com.springboot.siicoreapp.models.service.IRegistroVentasService;
import com.springboot.siicoreapp.models.service.ITerceroService;


@Controller
@RequestMapping("/ventas")
public class RegistroVentaController {
	
	@Autowired
	private IRegistroVentasService registroVentasService;
	
	@Autowired
	private ITerceroService terceroService;
	
	
	@Secured({"ROLE_ADMIN","ROLE_VENDEDOR","ROLE_ALMACENISTA"})
	@GetMapping("/")
	public String listarTodos(Model model) {
		
		model.addAttribute("titulo", "REGISTRO VENTAS");
		model.addAttribute("rventas", registroVentasService.listarTodos());
		
		return "/views/registroVentas/listarRegVentas";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/createventa")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Sale");
		model.addAttribute("rventas", new RegistroVenta());
		model.addAttribute("terceros", terceroService.listarTodos());
		
		return "/views/registroVentas/frmRegVentas";
	}
	
	
	@PostMapping("/saveventa")
	public String guardar( @ModelAttribute RegistroVenta registroVenta, Model model, RedirectAttributes attr) {
		
		registroVentasService.guardar(registroVenta);
		attr.addFlashAttribute("success", "Record saved successfully");
		model.addAttribute("terceros", terceroService.listarTodos());
		
		return "redirect:/ventas/";
	}

	
	@GetMapping("/edit/{id_registro_venta}")
	public String editar (@PathVariable ("id_registro_venta") Long idRegistroVenta, Model model) {
		
		model.addAttribute("titulo", "Form: Edit Sale");
		model.addAttribute("rventas", registroVentasService.buscarPorId(idRegistroVenta));
		model.addAttribute("terceros", terceroService.listarTodos());
		
		return "/views/registroVentas/frmRegVentas";
	}
	
	
	@GetMapping("/delete/{id_registro_venta}")
	public String eliminar(@PathVariable("id_registro_venta")Long idRegistroVenta, RedirectAttributes attr) {
		
		registroVentasService.eliminar(idRegistroVenta);
		attr.addFlashAttribute("warning", "Record was delete");
		
		return "redirect:/ventas/";
	}
}
