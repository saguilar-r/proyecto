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

import com.springboot.siicoreapp.models.entity.CategoriaProducto;
import com.springboot.siicoreapp.models.service.ICategoriaProductoService;

@Controller
@RequestMapping("/ctproductos")
public class CategoriaProductoController {

	@Autowired
	private ICategoriaProductoService categoriaProductoService;
	
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN","ROLE_AUXILIAR"})
	@GetMapping("/")
	public String listarTodos(Model model) {
		
		model.addAttribute("titulo", "CATEGORIA PRODUCTO");
		model.addAttribute("ctproducto", categoriaProductoService.listarTodos());
		
		return "/views/ctproductos/listarCtProductos";
	}
	
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN","ROLE_AUXILIAR"})
	@GetMapping("/createctp")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Category Product");
		model.addAttribute("ctproducto", new CategoriaProducto());
		
		return "/views/ctproductos/formCtProductos";
	}
	
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN","ROLE_AUXILIAR"})
	@PostMapping("/savectproductos")
	public String guardar(@ModelAttribute CategoriaProducto categoriaProducto,Model model, RedirectAttributes attr) {
		
		categoriaProductoService.guardar(categoriaProducto);
		attr.addFlashAttribute("success", "Record saved successfully");
		
		return "redirect:/ctproductos/";
	}
	
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN","ROLE_AUXILIAR"})
	@GetMapping("/edit/{id_categoria_producto}")
	public String editar(@PathVariable("id_categoria_producto") Long idCatProducto, Model model) {
		
		model.addAttribute("titulo", "Form: Category Product Edit");
		model.addAttribute("ctproducto", categoriaProductoService.buscarPorId(idCatProducto));
		
		return "/views/ctproductos/formCtProductos";
	}
	
	@Secured({"ROLE_ALMACENISTA", "ROLE_ADMIN"})
	@GetMapping("/delete/{id_categoria_producto}")
	public String eliminar(@PathVariable("id_categoria_producto") Long idCatProducto, RedirectAttributes attribute) {

		categoriaProductoService.eliminar(idCatProducto);
		System.out.println("Registro Eliminado con Exito");
		attribute.addFlashAttribute("warning", "Record was delete successfully!");

		return "redirect:/ctproductos/";
	}

}

