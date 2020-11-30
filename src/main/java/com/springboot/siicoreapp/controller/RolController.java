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
		
		Rol rol = new Rol();
		
		model.addAttribute("titulo", "Form: New Role");
		model.addAttribute("rol", rol);
		model.addAttribute("usuario", usuarioService.ListarTodos());
		return "/views/roles/frmCrear";
	}
	
	@PostMapping("/save") 
	public String guardar(@ModelAttribute Rol rol, Model model, RedirectAttributes attr) {
			  
		rolService.guardar(rol);
		attr.addFlashAttribute("success", "Rol guardado exitosamente");
		System.out.println("Rol guardado exitosamente");
		model.addAttribute("usuario", usuarioService.ListarTodos());
	    return "redirect:/rol/"; 	
	    
	}
	
	/*
	 * @PostMapping("/save") public String guardar(@Param("nombre_rol") String
	 * nombre_rol) {
	 * 
	 * System.out.println(nombre_rol); //rolesService.guardar(role);
	 * System.out.println("Role saved successfully"); return
	 * "redirect:/views/roles/"; }
	 */
	/*
	 * @GetMapping("/edit/{id_rol}") public String editar(@PathVariable("id_rol")
	 * Long idRol, Model model) {
	 * 
	 * 
	 * model.addAttribute("titulo", "Form: Role Edit"); model.addAttribute("role",
	 * rolesService.buscarPorId(idRol)); return "/views/roles/frmCrear"; }
	 */
	@GetMapping("/edit/{id_rol}")
	public String editar(@PathVariable("id_rol") Long idRol, Model model) {
			
		/* Rol rol = new Rol(); */
		
		
		model.addAttribute("titulo", "Formulario: Rol Edit");
		model.addAttribute("rol", rolService.buscarPorId(idRol));
		model.addAttribute("usuario", usuarioService.ListarTodos());
		

		return "/views/roles/frmCrear";
	}
		
	
	//@GetMapping("/delete/{id_rol}")
	@GetMapping("/delete/{id_rol}")
	public String eliminar(@PathVariable("id_rol") Long idRol, RedirectAttributes attribute) {

		rolService.eliminar(idRol);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Record was delete successfully!");

		return "redirect:/rol/";
	}

}


