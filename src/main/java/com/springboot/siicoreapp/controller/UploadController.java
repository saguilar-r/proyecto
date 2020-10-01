package com.springboot.siicoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.siicoreapp.models.entity.Producto;
import com.springboot.siicoreapp.models.service.UFService;

@Controller
public class UploadController {
	
	
	@Autowired
	private UFService uFService;

	@GetMapping("/cargar-info")
	public String cargarInfo(Model model) {
		model.addAttribute("titulo", "Carga de productos");
		model.addAttribute("producto", new Producto());		
		return "/UploadFile";
	}
	
	@PostMapping("/cargar-info")
	public String cargarArchivo(@ModelAttribute Producto producto, RedirectAttributes redirectAttributes) {
		boolean isFlag = false;

		try {
			isFlag = uFService.saveDataFromUploadFile(producto.getFile());
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
		}

		if (isFlag) {
			redirectAttributes.addFlashAttribute("success","Se ha cargado la informacion correctamente a la base de datos!");
		} else {
			redirectAttributes.addFlashAttribute("error","Oh no!, algo ha ocurrido, por favor revise las recomendaciones.");
			return "redirect:/producto/cargar-info";
		}

		return "redirect:/productos/";
	}
}
