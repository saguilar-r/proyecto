package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.CategoriaProducto;

public interface ICategoriaProductoService {
	
	public List<CategoriaProducto> listarTodos();
	public void guardar(CategoriaProducto categoriaProducto);
	public CategoriaProducto buscarPorId(Long id_categoria_producto);
	public void eliminar (Long id_categoria_producto);

}
