package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.Rol;

public interface IRolService {
	
	public List<Rol> listarRoles();
	public void guardar (Rol rol);
	public Rol buscarPorId(Long id_rol);
	public void eliminar(Long id_rol);

}
