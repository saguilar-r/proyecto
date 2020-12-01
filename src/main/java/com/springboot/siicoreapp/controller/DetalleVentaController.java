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

import com.springboot.siicoreapp.models.entity.DetalleVenta;
import com.springboot.siicoreapp.models.service.IDetalleVentaService;
import com.springboot.siicoreapp.models.service.IProductoService;
import com.springboot.siicoreapp.models.service.IRegistroVentasService;

@Controller
@RequestMapping("/dventas")
public class DetalleVentaController {
	
	@Autowired
	private IDetalleVentaService detalleVentaService;
	
	@Autowired
	private IRegistroVentasService registroVentaService;
	
	@Autowired
	private IProductoService productoService;
	
	@Secured({"ROLE_VENDEDOR", "ROLE_ADMIN","ROLE_ALMACENISTA"})
	@GetMapping("/")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "DETALLE VENTA");
		model.addAttribute("dventas", detalleVentaService.listarTodos());
		
		return "/views/detalleVentas/listaDetalleV";
	}
	@Secured({"ROLE_VENDEDOR", "ROLE_ADMIN", "ROLE_ALMACENISTA"})
	@GetMapping("/createDetalleV")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Record");
		model.addAttribute("dventas", new DetalleVenta());
		model.addAttribute("ventas", registroVentaService.listarTodos());
		model.addAttribute("productos", productoService.listarTodos());
		
		return "/views/detalleVentas/frmDetalleV";
	}
	@Secured({"ROLE_VENDEDOR", "ROLE_ADMIN","ROLE_ALMACENISTA"})
	@PostMapping("/saveDetalleV")
	public String guardar(@ModelAttribute DetalleVenta detalleVenta, Model model, RedirectAttributes attr) {
		
		detalleVentaService.guardar(detalleVenta);
		attr.addFlashAttribute("success", "Record was saved successfully");
		model.addAttribute("ventas", registroVentaService.listarTodos());
    	model.addAttribute("productos", productoService.listarTodos());
    	
    	return "redirect:/dventas/";
		
	}
	@Secured({"ROLE_VENDEDOR", "ROLE_ADMIN", "ROLE_ALMACENISTA"})
	@GetMapping("/edit/{id_detalle_registro_ventas}")
	public String editar(@PathVariable("id_detalle_registro_ventas") Long idDetalleVenta, Model model) {
	
		model.addAttribute("titulo", "Form: Edit Record");
		model.addAttribute("dventas", detalleVentaService.buscarPorId(idDetalleVenta));
		model.addAttribute("ventas", registroVentaService.listarTodos());
		model.addAttribute("productos", productoService.listarTodos());
		
		return "/views/detalleVentas/frmDetalleV";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id_detalle_registro_ventas}")
	public String eliminar(@PathVariable("id_detalle_registro_ventas") Long idDetalleVenta, RedirectAttributes attr) {
		
		detalleVentaService.eliminar(idDetalleVenta);
		attr.addFlashAttribute("warning", "Record was delete");
		
		return "redirect:/dventas/";
	}
}