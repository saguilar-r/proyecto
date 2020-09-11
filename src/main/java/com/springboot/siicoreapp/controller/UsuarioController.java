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

import com.springboot.siicoreapp.models.entity.Rol;
import com.springboot.siicoreapp.models.entity.Usuario;
import com.springboot.siicoreapp.models.service.IRolService;
import com.springboot.siicoreapp.models.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IRolService rolService;
	
	@GetMapping("/")
	public String listarUsuarios(Model model) {
		
		List<Usuario> listadoUsuarios = usuarioService.ListarTodos();
		
		model.addAttribute("titulo", "USER LIST");
		model.addAttribute("usuarios", listadoUsuarios);
		return "/views/usuarios/listausuarios";
	}

	@GetMapping("/createUser")
	public String crear(Model model) {
		
		/* Usuario usuario = new Usuario(); */
		/* List<Rol> listRol= rolService.listarRoles(); */
		
		model.addAttribute("titulo", "Form: New User");
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("roles", rolService.listarRoles());
		
		return "/views/usuarios/frmCrearUsuario";
	}
	
	@PostMapping("/saveUser") 
	public String guardar(@ModelAttribute Usuario usuario, Model model, RedirectAttributes attr) {
		
		List<Rol> listRol= rolService.listarRoles();
		
		usuarioService.guardar(usuario);
		attr.addFlashAttribute("success", "User saved successfully");
		model.addAttribute("roles", listRol);
		System.out.println("User saved successfully"); 
	    
		return "redirect:/usuarios/"; 	
	}
	
	@GetMapping("/edit/{id_usuario}")
	public String editar(@PathVariable ("id_usuario") Long idUsuario, Model model) {
		
		List<Rol> listRol= rolService.listarRoles();
		
		model.addAttribute("titulo", "Form: User Edit");
		model.addAttribute("usuario", usuarioService.buscarPorId(idUsuario));
		model.addAttribute("roles", listRol);
		
		return "/views/usuarios/frmCrearUsuario";
	}
	
	@GetMapping("/delete/{id_usuario}")
	public String eliminar(@PathVariable("id_usuario") Long idUsuario, RedirectAttributes attribute) {
		
		usuarioService.eliminar(idUsuario);
		attribute.addFlashAttribute("warning", "Record was delete successfully!");
		
		return "redirect:/usuarios/";
	}
}
