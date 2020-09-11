package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.Cargo;
import com.springboot.siicoreapp.models.repository.CargoRepository;

@Service
public class CargoServiceImpl implements ICargoService {
	
	@Autowired
	private CargoRepository cargoRepository;

	@Override
	public List<Cargo> listarTodos() {
		
		return (List<Cargo>) cargoRepository.findAll();
	}

	@Override
	public void guardar(Cargo cargo) {
		cargoRepository.save(cargo);

	}

	@Override
	public Cargo buscarPorId(Long id_cargo) {
		
		return cargoRepository.findById(id_cargo).orElse(null);
	}

	@Override
	public void eliminar(Long id_cargo) {
		cargoRepository.deleteById(id_cargo);

	}

}
