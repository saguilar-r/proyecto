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

import com.springboot.siicoreapp.models.entity.DetalleCompra;

import com.springboot.siicoreapp.models.service.IDetalleCompraService;

import com.springboot.siicoreapp.models.service.IProductoService;
import com.springboot.siicoreapp.models.service.IRegistroCompraService;


@Controller
@RequestMapping("/dcompras")
public class DetalleCompraController {
	
	@Autowired
	private IDetalleCompraService detalleCompraService;
	
	@Autowired
	private IRegistroCompraService registroCompraService;
	
	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("/")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "PURCHASE DETAIL RECORDS");
		model.addAttribute("dcompras", detalleCompraService.listarTodos());
		
		return "/views/detalleCompras/listaDetalleC";
	}
	
	@GetMapping("/createDetalleC")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Record");
		model.addAttribute("dcompras", new DetalleCompra());
		model.addAttribute("compras", registroCompraService.listaTodos());
		model.addAttribute("productos", productoService.listarTodos());
		
		return "/views/detalleCompras/frmDetalleC";
	}
	
	@PostMapping("/saveDetalleC")
	public String guardar(@ModelAttribute DetalleCompra detalleCompra, Model model, RedirectAttributes attr) {
		
		detalleCompraService.guardar(detalleCompra);
		attr.addFlashAttribute("success", "Record was saved successfully");
		model.addAttribute("compras", registroCompraService.listaTodos());
    	model.addAttribute("productos", productoService.listarTodos());
    	
    	return "redirect:/dcompras/";
		
	}
	
	@GetMapping("/edit/{id_detalle_registro_compra}")
	public String editar(@PathVariable("id_detalle_registro_compra") Long idDetalleCompra, Model model) {
	
		model.addAttribute("titulo", "Form: Edit Record");
		model.addAttribute("dcompras", detalleCompraService.buscarPorId(idDetalleCompra));
		model.addAttribute("compras", registroCompraService.listaTodos());
		model.addAttribute("productos", productoService.listarTodos());
		
		return "/views/detalleCompras/frmDetalleC";
	}
	
	@GetMapping("/delete/{id_detalle_registro_compra}")
	public String eliminar(@PathVariable("id_detalle_registro_compra") Long idDetalleCompra, RedirectAttributes attr) {
		
		detalleCompraService.eliminar(idDetalleCompra);
		attr.addFlashAttribute("warning", "Record was delete");
		
		return "redirect:/dcompras/";
	}
}


