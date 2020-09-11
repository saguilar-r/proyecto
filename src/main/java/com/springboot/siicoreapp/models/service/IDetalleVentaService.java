package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.DetalleVenta;

public interface IDetalleVentaService {
	
	public List<DetalleVenta> listarTodos();
	public void guardar(DetalleVenta detalleVenta);
	public DetalleVenta buscarPorId(Long id_detalle_registro_ventas);
	public void eliminar(Long id_detalle_registro_ventas);

}
