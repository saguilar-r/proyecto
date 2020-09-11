package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.CategoriaTercero;
import com.springboot.siicoreapp.models.repository.CategoriaTerceroRepository;

@Service
public class CategoriaTerceroServiceImpl implements ICategoriaTercero {
	
	@Autowired
	private CategoriaTerceroRepository categoriaTerceroRepository;

	@Override
	public List<CategoriaTercero> listarTodos() {
		return (List<CategoriaTercero>) categoriaTerceroRepository.findAll();
	}

	@Override
	public void guardar(CategoriaTercero categoriaTercero) {
		categoriaTerceroRepository.save(categoriaTercero);
	}

	@Override
	public CategoriaTercero buscarPorId(Long id_categoria_tercero) {
	
		return categoriaTerceroRepository.findById(id_categoria_tercero).orElse(null);
	}

	@Override
	public void eliminar(Long id_categoria_tercero) {
		categoriaTerceroRepository.deleteById(id_categoria_tercero);

	}

}
