package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.Tercero;
import com.springboot.siicoreapp.models.repository.TerceroRepository;

@Service
public class TerceroServiceImpl implements ITerceroService {
	
	@Autowired
	private TerceroRepository terceroRepository;

	@Override
	public List<Tercero> listarTodos() {
		
		return (List<Tercero>) terceroRepository.findAll();
	}

	@Override
	public void guardar(Tercero tercero) {
		terceroRepository.save(tercero);

	}

	@Override
	public Tercero buscarPorId(Long id_tercero) {
		
		return terceroRepository.findById(id_tercero).orElse(null);
	}

	@Override
	public void eliminar(Long id_tercero) {
		terceroRepository.deleteById(id_tercero);

	}

}
