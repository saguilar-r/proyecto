package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.RegistroInventario;

public interface IRegistroInventarioService {
	
	public List<RegistroInventario> listarTodos();
	public void guardar(RegistroInventario registroInventario);
	public RegistroInventario buscarPorId(Long id_registro_inventario);
	public void eliminar(Long id_registro_inventario);

}
