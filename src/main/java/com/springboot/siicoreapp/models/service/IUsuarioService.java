package com.springboot.siicoreapp.models.service;

import java.util.List;

import com.springboot.siicoreapp.models.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> ListarTodos();
	public void guardar(Usuario usuario);
	public Usuario buscarPorId(Long id_usuario);
	public void eliminar(Long id_usuario);

}
