package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.DetalleInventario;
import com.springboot.siicoreapp.models.repository.DetalleInventarioRepository;

@Service
public class DetalleInventarioServiceImpl implements IDetalleInventarioService {

	@Autowired
	private DetalleInventarioRepository detalleInventarioRepository;
	
	@Override
	public List<DetalleInventario> listarTodos() {
		
		return (List<DetalleInventario>) detalleInventarioRepository.findAll();
	}

	@Override
	public void guardar(DetalleInventario detalleInventario) {
		detalleInventarioRepository.save(detalleInventario);

	}

	@Override
	public DetalleInventario buscarPorId(Long id_detalle_registro_inventario) {
		
		return detalleInventarioRepository.findById(id_detalle_registro_inventario).orElse(null);
	}

	@Override
	public void eliminar(Long id_detalle_registro_inventario) {
		detalleInventarioRepository.deleteById(id_detalle_registro_inventario);
	}

}
