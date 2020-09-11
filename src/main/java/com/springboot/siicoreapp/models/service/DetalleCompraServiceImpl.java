package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.DetalleCompra;
import com.springboot.siicoreapp.models.repository.DetalleCompraRepository;

@Service
public class DetalleCompraServiceImpl implements IDetalleCompraService {

	@Autowired
	private DetalleCompraRepository detalleCompraRepository;
	
	@Override
	public List<DetalleCompra> listarTodos() {
	
		return (List<DetalleCompra>) detalleCompraRepository.findAll();
	}

	@Override
	public void guardar(DetalleCompra detalleCompra) {
		detalleCompraRepository.save(detalleCompra);

	}

	@Override
	public DetalleCompra buscarPorId(Long id_detalle_registro_compra) {
		
		return detalleCompraRepository.findById(id_detalle_registro_compra).orElse(null);
	}

	@Override
	public void eliminar(Long id_detalle_registro_compra) {
		detalleCompraRepository.deleteById(id_detalle_registro_compra);

	}

}
