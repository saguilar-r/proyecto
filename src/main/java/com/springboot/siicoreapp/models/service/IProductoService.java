package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> listarTodos();
	public void guardar(Producto producto);
	public Producto buscarPorId(Long id_producto);
	public void eliminar(Long id_producto);

}
