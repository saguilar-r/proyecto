package com.springboot.siicoreapp.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Principal principal, RedirectAttributes attr ) {
		
		if(principal!=null) {
			attr.addFlashAttribute("warning","ATENCIÓN: Usted ya ha iniciado sesión previamente");
			
			return "redirect:/index";
		}
		return "login";
	}

}
