package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.RegistroVenta;

public interface IRegistroVentasService {
	
	public List<RegistroVenta> listarTodos();
	public void guardar(RegistroVenta registroVenta);
	public RegistroVenta buscarPorId(Long id_registro_venta);
	public void eliminar(Long id_registro_venta);

}
