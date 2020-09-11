package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.RegistroVenta;
import com.springboot.siicoreapp.models.repository.RegistroVentasRepository;


@Service
public class RegistroVentaServiceImpl implements IRegistroVentasService {
	
	@Autowired
	private RegistroVentasRepository registroVentasRepository;

	@Override
	public List<RegistroVenta> listarTodos() {
		
		return (List<RegistroVenta>) registroVentasRepository.findAll();
	}

	@Override
	public void guardar(RegistroVenta registroVenta) {
		registroVentasRepository.save(registroVenta);

	}

	@Override
	public RegistroVenta buscarPorId(Long id_registro_venta) {
		
		return registroVentasRepository.findById(id_registro_venta).orElse(null);
	}

	@Override
	public void eliminar(Long id_registro_venta) {
		registroVentasRepository.deleteById(id_registro_venta);

	}

}
