package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.DetalleVenta;
import com.springboot.siicoreapp.models.repository.DetalleVentaRepository;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

	@Autowired
	private DetalleVentaRepository detalleVentaRepository;
	
	@Override
	public List<DetalleVenta> listarTodos() {
		
		return (List<DetalleVenta>) detalleVentaRepository.findAll();
	}

	@Override
	public void guardar(DetalleVenta detalleVenta) {
		detalleVentaRepository.save(detalleVenta);

	}

	@Override
	public DetalleVenta buscarPorId(Long id_detalle_registro_ventas) {
		return detalleVentaRepository.findById(id_detalle_registro_ventas).orElse(null);
	}

	@Override
	public void eliminar(Long id_detalle_registro_ventas) {
		detalleVentaRepository.deleteById(id_detalle_registro_ventas);

	}

}
