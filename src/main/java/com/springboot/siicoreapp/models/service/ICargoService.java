package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.Cargo;

public interface ICargoService {
	
	public List<Cargo> listarTodos();
	public void guardar(Cargo cargo);
	public Cargo buscarPorId(Long id_cargo);
	public void eliminar(Long id_cargo);

}
