package com.springboot.siicoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.springboot.siicoreapp.models.entity.Empleado;
import com.springboot.siicoreapp.models.service.ICargoService;
import com.springboot.siicoreapp.models.service.IEmpleadoService;
import com.springboot.siicoreapp.models.service.IUsuarioService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private ICargoService cargoService;
	
	@GetMapping("/")
	public String listarEmpleados(Model model) {
		
		model.addAttribute("titulo", "Employee List");
		model.addAttribute("empleados", empleadoService.listarTodos());
		
		return "/views/empleados/listaEmpleados";
	}
	
	@GetMapping("/createEmpl")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Employee");
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("usuario", usuarioService.ListarTodos());
		model.addAttribute("cargos", cargoService.listarTodos());
		
		return "/views/empleados/crearEmpleado";
	}
	
	@PostMapping("/saveEmpl")
	public String guardar(@ModelAttribute Empleado empleado, Model model, RedirectAttributes attr) {
		
		
		empleadoService.guardar(empleado);
		attr.addFlashAttribute("success", "Employee saved successfully");
		model.addAttribute("usuario", usuarioService.ListarTodos());
		model.addAttribute("cargo", cargoService.listarTodos());
		System.out.println("Employee saved successfully");
		
		return "redirect:/empleados/";
	}
	

}
