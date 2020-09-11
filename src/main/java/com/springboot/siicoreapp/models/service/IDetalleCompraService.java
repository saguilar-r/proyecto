package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.DetalleCompra;

public interface IDetalleCompraService {
	
	public List<DetalleCompra> listarTodos();
	public void guardar(DetalleCompra detalleCompra);
	public DetalleCompra buscarPorId(Long id_detalle_registro_compra);
	public void eliminar (Long id_detalle_registro_compra);

}
