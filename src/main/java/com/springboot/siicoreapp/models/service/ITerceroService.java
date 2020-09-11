package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.Tercero;

public interface ITerceroService {
	
	public List<Tercero> listarTodos();
	public void guardar(Tercero tercero);
	public Tercero buscarPorId(Long id_tercero);
	public void eliminar(Long id_tercero);

}
