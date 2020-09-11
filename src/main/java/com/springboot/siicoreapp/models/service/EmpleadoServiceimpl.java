package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.Empleado;
import com.springboot.siicoreapp.models.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceimpl implements IEmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> listarTodos() {
		
		return (List<Empleado>) empleadoRepository.findAll();
	}

	@Override
	public void guardar(Empleado empleado) {
		
		empleadoRepository.save(empleado);

	}

	@Override
	public Empleado buscarPorId(Long id_empleado) {
		
		return empleadoRepository.findById(id_empleado).orElse(null);
	}

	@Override
	public void eliminar(Long id_empleado) {
		empleadoRepository.deleteById(id_empleado);

	}

}
