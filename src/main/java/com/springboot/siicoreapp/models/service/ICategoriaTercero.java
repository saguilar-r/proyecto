package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.CategoriaTercero;

public interface ICategoriaTercero {
	
	public List<CategoriaTercero> listarTodos();
	public void guardar(CategoriaTercero categoriaTercero);
	public CategoriaTercero buscarPorId(Long id_categoria_tercero);
	public void eliminar(Long id_categoria_tercero);

}
