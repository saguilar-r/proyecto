package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.DetalleInventario;

public interface IDetalleInventarioService {
	public List<DetalleInventario> listarTodos();
	public void guardar(DetalleInventario detalleInventario);
	public DetalleInventario buscarPorId(Long id_detalle_registro_inventario);
	public void eliminar(Long id_detalle_registro_inventario);

}
