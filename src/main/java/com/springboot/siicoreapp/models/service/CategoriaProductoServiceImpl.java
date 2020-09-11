package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.CategoriaProducto;
import com.springboot.siicoreapp.models.repository.CategoriaProductoRepository;

@Service
public class CategoriaProductoServiceImpl implements ICategoriaProductoService {
	
	@Autowired
	private CategoriaProductoRepository categoriaProductoRepository;
	
	@Override
	public List<CategoriaProducto> listarTodos() {
		
		return (List<CategoriaProducto>) categoriaProductoRepository.findAll();
	}

	@Override
	public void guardar(CategoriaProducto categoriaProducto) {
		
		categoriaProductoRepository.save(categoriaProducto);

	}

	@Override
	public CategoriaProducto buscarPorId(Long id_categoria_producto) {
		
		return categoriaProductoRepository.findById(id_categoria_producto).orElse(null);
	}

	@Override
	public void eliminar(Long id_categoria_producto) {
		categoriaProductoRepository.deleteById(id_categoria_producto);

	}

}
