package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.RegistroCompra;

public interface IRegistroCompraService {
	
	public List<RegistroCompra> listaTodos();
	public void guardar(RegistroCompra registroCompra);
	public RegistroCompra buscarPorId(Long id_registro_compra);
	public void eliminar(Long id_registro_compra);

}
