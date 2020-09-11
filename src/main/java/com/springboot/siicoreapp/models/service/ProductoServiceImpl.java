package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.Producto;
import com.springboot.siicoreapp.models.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listarTodos() {
		
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);

	}

	@Override
	public Producto buscarPorId(Long id_producto) {
		
		return productoRepository.findById(id_producto).orElse(null);
	}

	@Override
	public void eliminar(Long id_producto) {
		productoRepository.deleteById(id_producto);

	}

}
