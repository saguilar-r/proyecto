package com.springboot.siicoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.springboot.siicoreapp.models.entity.User;

import com.springboot.siicoreapp.models.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	

	@GetMapping("/")
	public String listarUsuarios(Model model) {
		
		List<User> listadoUsuarios = usuarioService.ListarTodos();
		
		model.addAttribute("titulo", "USER LIST");
		model.addAttribute("usuarios", listadoUsuarios);
		return "/views/usuarios/listausuarios";
	}

	@GetMapping("/createUser")
	public String crear(Model model) {
		
		
		model.addAttribute("titulo", "Form: New User");
		model.addAttribute("usuario", new User());
		
		return "/views/usuarios/frmCrearUsuario";
	}
	
	@PostMapping("/saveUser") 
	public String guardar(@ModelAttribute User usuario, Model model, RedirectAttributes attr) {
		
		System.out.println(usuario);
		usuarioService.guardar(usuario);
		attr.addFlashAttribute("success", "User saved successfully");
		System.out.println("User saved successfully"); 
	    
		return "redirect:/usuarios/"; 	
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Long id, Model model) {
	
		
		model.addAttribute("titulo", "Form: User Edit");
		model.addAttribute("usuario", usuarioService.buscarPorId(id));
		
		return "/views/usuarios/frmCrearUsuario";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long id, RedirectAttributes attribute) {
		
		usuarioService.eliminar(id);
		attribute.addFlashAttribute("warning", "Record was delete successfully!");
		
		return "redirect:/usuarios/";
	}
}
