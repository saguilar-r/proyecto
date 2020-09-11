package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.RegistroInventario;
import com.springboot.siicoreapp.models.repository.RegistroInventarioRepository;

@Service
public class RegistroInventarioServiceImpl implements IRegistroInventarioService {
	
	@Autowired
	private RegistroInventarioRepository registroInventarioRepository;

	@Override
	public List<RegistroInventario> listarTodos() {
		
		return (List<RegistroInventario>) registroInventarioRepository.findAll();
	}

	@Override
	public void guardar(RegistroInventario registroInventario) {
		registroInventarioRepository.save(registroInventario);

	}

	@Override
	public RegistroInventario buscarPorId(Long id_registro_inventario) {
		
		return registroInventarioRepository.findById(id_registro_inventario).orElse(null);
	}

	@Override
	public void eliminar(Long id_registro_inventario) {
		registroInventarioRepository.deleteById(id_registro_inventario);

	}

}
