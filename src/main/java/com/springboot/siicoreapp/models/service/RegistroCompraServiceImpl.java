package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.RegistroCompra;
import com.springboot.siicoreapp.models.repository.RegistroCompraRepository;

@Service
public class RegistroCompraServiceImpl implements IRegistroCompraService {
	
	@Autowired
	private RegistroCompraRepository registroCompraRepository;

	@Override
	public List<RegistroCompra> listaTodos() {
		
		return (List<RegistroCompra>) registroCompraRepository.findAll();
	}

	@Override
	public void guardar(RegistroCompra registroCompra) {
		registroCompraRepository.save(registroCompra);

	}

	@Override
	public RegistroCompra buscarPorId(Long id_registro_compra) {
		
		return registroCompraRepository.findById(id_registro_compra).orElse(null);
	}

	@Override
	public void eliminar(Long id_registro_compra) {
		registroCompraRepository.deleteById(id_registro_compra);

	}

}
