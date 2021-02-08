package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.User;


public interface IUsuarioService {
	
	public List<User> ListarTodos();
	public void guardar(User user);
	public User buscarPorId(Long id);
	public void eliminar(Long id);

}
