package com.springboot.siicoreapp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {
	
	@GetMapping("/file")
	public String indexs() {
		
		return "/upload";
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attr) throws IOException {
		
		if(file == null || file.isEmpty()) {
			attr.addFlashAttribute("message", "Por favor seleccione un archivo");
			return "redirect:status";
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(System.getProperty("user.home"));
		builder.append(File.separator);
		builder.append("spring_upload_file");
		builder.append(File.separator);
		builder.append(file.getOriginalFilename());
		
		byte[] fileBytes = file.getBytes();
		Path path = Paths.get(builder.toString());
		Files.write(path, fileBytes);
		
		attr.addFlashAttribute("message", "Archivo cargado correctamente ["+builder.toString()+"]");
		
		return "redirect:/status";
	}
	
	@GetMapping("/status")
	public String status() {
		return "status";
	}

}
