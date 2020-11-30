package com.springboot.siicoreapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FProducto {
	
	@GetMapping("/fproductos")
	public String fproducto() {
		
		return "fproductos";
	}

}
