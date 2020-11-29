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


import com.springboot.siicoreapp.models.entity.DetalleInventario;

import com.springboot.siicoreapp.models.service.IDetalleInventarioService;
import com.springboot.siicoreapp.models.service.IProductoService;

import com.springboot.siicoreapp.models.service.IRegistroInventarioService;

@Controller
@RequestMapping("/dstock")
public class DetalleInventarioController {

	@Autowired
	private IDetalleInventarioService detalleInventarioService;
	
	@Autowired
	private IRegistroInventarioService registroInventarioService;
	
	@Autowired
	private IProductoService productoService;
	
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN"})
	@GetMapping("/")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "DETALLE STOCK");
		model.addAttribute("dstock", detalleInventarioService.listarTodos());
		
		return "/views/detalleInventario/listaDetalleS";
	}
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN"})
	@GetMapping("/createDetalleS")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Record");
		model.addAttribute("dstock", new DetalleInventario());
		model.addAttribute("stock", registroInventarioService.listarTodos());
		model.addAttribute("productos", productoService.listarTodos());
		
		return "/views/detalleInventario/frmDetalleS";
	}
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN"})
	@PostMapping("/saveDetalleS")
	public String guardar(@ModelAttribute DetalleInventario detalleInventario, Model model, RedirectAttributes attr) {
		
		detalleInventarioService.guardar(detalleInventario);
		attr.addFlashAttribute("success", "Record was saved successfully");
		model.addAttribute("stock", registroInventarioService.listarTodos());
    	model.addAttribute("productos", productoService.listarTodos());
    	
    	return "redirect:/dstock/";
		
	}
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN"})
	@GetMapping("/edit/{id_detalle_registro_inventario}")
	public String editar(@PathVariable("id_detalle_registro_inventario") Long idDetalleStock, Model model) {
	
		model.addAttribute("titulo", "Form: Edit Record");
		model.addAttribute("dstock", detalleInventarioService.buscarPorId(idDetalleStock));
		model.addAttribute("stock", registroInventarioService.listarTodos());
		model.addAttribute("productos", productoService.listarTodos());
		
		return "/views/detalleInventario/frmDetalleS";
	}
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN"})
	@GetMapping("/delete/{id_detalle_registro_inventario}")
	public String eliminar(@PathVariable("id_detalle_registro_inventario") Long idDetalleStock, RedirectAttributes attr) {
		
		detalleInventarioService.eliminar(idDetalleStock);
		attr.addFlashAttribute("warning", "Record was delete");
		
		return "redirect:/dstock/";
	}
}
