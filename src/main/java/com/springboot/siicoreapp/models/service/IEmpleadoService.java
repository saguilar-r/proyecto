package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> listarTodos();
	public void guardar(Empleado empleado);
	public Empleado buscarPorId(Long id_empleado);
	public void eliminar(Long id_empleado);

}
