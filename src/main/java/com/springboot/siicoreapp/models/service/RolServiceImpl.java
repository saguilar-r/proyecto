package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.Rol;
import com.springboot.siicoreapp.models.repository.RolRepository;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public List<Rol> listarRoles() {
		return (List<Rol>) rolRepository.findAll();
	}

	@Override
	public void guardar(Rol rol) {
		rolRepository.save(rol);

	}

	@Override
	public Rol buscarPorId(Long id_rol) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id_rol).orElse(null);
	}

	@Override
	public void eliminar(Long id_rol) {
		
		rolRepository.deleteById(id_rol);
	
	}

}
