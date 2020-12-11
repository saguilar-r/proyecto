package com.springboot.siicoreapp.controller;

import java.util.List;

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

import com.springboot.siicoreapp.models.entity.Rol;
import com.springboot.siicoreapp.models.service.IRolService;
import com.springboot.siicoreapp.models.service.IUsuarioService;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/rol")
public class RolController {
	
	@Autowired
	private IRolService rolService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/")
	public String listarRoles(Model model) {
		
		List<Rol> listadoRoles = rolService.listarRoles();
		
		model.addAttribute("titulo", "ROLES");
		model.addAttribute("roles", listadoRoles);
		
		return "/views/roles/listar";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Nuevo Rol");
		model.addAttribute("rol", new Rol());
		model.addAttribute("usuario", usuarioService.ListarTodos());
		return "/views/roles/frmCrear";
	}
	
	@PostMapping("/save-rol") 
	public String guardar(@ModelAttribute Rol rol, Model model, RedirectAttributes attr) {
			  
		System.out.println(rol);
		rolService.guardar(rol);
		attr.addFlashAttribute("success", "Rol guardado exitosamente");
		System.out.println("Rol guardado exitosamente");
		model.addAttribute("usuario", usuarioService.ListarTodos()); 
	    return "redirect:/rol/"; 	
	    
	}
	
	@GetMapping("/edit/{id_rol}")
	public String editar(@PathVariable("id_rol") Long idRol, Model model) {
			
		/* Rol rol = new Rol(); */
		
		
		model.addAttribute("titulo", "Formulario: EDITAR ROL");
		model.addAttribute("rol", rolService.buscarPorId(idRol));
		model.addAttribute("usuario", usuarioService.ListarTodos());
		

		return "/views/roles/frmCrear";
	}
		
	

	@GetMapping("/delete/{id_rol}")
	public String eliminar(@PathVariable("id_rol") Long idRol, Model model, RedirectAttributes attribute) {

		rolService.eliminar(idRol);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro eliminado exitosamente");

		return "redirect:/rol/";
	}

}


