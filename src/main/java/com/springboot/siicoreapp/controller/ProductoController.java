package com.springboot.siicoreapp.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.siicoreapp.models.entity.Producto;
import com.springboot.siicoreapp.models.service.ICategoriaProductoService;
import com.springboot.siicoreapp.models.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private ICategoriaProductoService categoriaProductoService;
	
	@Secured({"ROLE_VENDEDOR", "ROLE_ADMIN", "ROLE_ALMACENISTA"})
	@GetMapping("/")
	public String listarTodos(Model model) {
		
		model.addAttribute("titulo", "PRODUCTOS");
		model.addAttribute("productos", productoService.listarTodos());
		
		return "/views/productos/listaProductos";
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_ALMACENISTA"})
	@GetMapping("/createProducto")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Form: New Product");
		model.addAttribute("producto", new Producto());
		model.addAttribute("ctproductos", categoriaProductoService.listarTodos());
		
		return "/views/productos/formProductos";
	}
	@Secured({"ROLE_ADMIN", "ROLE_ALMACENISTA"})
	@PostMapping("/saveProducto")
	public String guardar(@ModelAttribute Producto producto, Model model, @RequestParam("file") MultipartFile imagen, RedirectAttributes attr) {
		
		if(!imagen.isEmpty()) {
			
			Path directorioImagenes = Paths.get("src//main//resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				
				producto.setImagen(imagen.getOriginalFilename());
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		
		productoService.guardar(producto);
		attr.addFlashAttribute("success", "Product Saved Successfully");
		model.addAttribute("ctproductos", categoriaProductoService.listarTodos());
		
		return "redirect:/productos/";
	}
	@Secured({"ROLE_ADMIN", "ROLE_ALMACENISTA"})
	@GetMapping("/edit/{id_producto}")
	public String editar(@PathVariable ("id_producto") Long idProducto,Model model) {
		model.addAttribute("titulo", "Form: Edit Product");
		model.addAttribute("producto", productoService.buscarPorId(idProducto));
		model.addAttribute("ctproductos", categoriaProductoService.listarTodos());
		
		return "/views/productos/formProductos";
		
	}
	@Secured({"ROLE_ADMIN", "ROLE_ALMACENISTA"})
	@GetMapping("/delete/{id_producto}")
	public String eliminar(@PathVariable("id_producto")Long idProducto, Model model, RedirectAttributes attr) {
		
		productoService.eliminar(idProducto);
		attr.addFlashAttribute("warning", "Record was delete");
		
		return "redirect:/productos/";
	}
}
