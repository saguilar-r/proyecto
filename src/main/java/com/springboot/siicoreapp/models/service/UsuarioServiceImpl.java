package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.User;

import com.springboot.siicoreapp.models.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<User> ListarTodos() {
		// TODO Auto-generated method stub
		return (List<User>) usuarioRepository.findAll();
	}

	@Override
	public void guardar(User user) {
		usuarioRepository.save(user);

	}

	@Override
	public User buscarPorId(Long id_usuario) {
		return usuarioRepository.findById(id_usuario).orElse(null);
	}

	@Override
	public void eliminar(Long id_usuario) {
		usuarioRepository.deleteById(id_usuario);

	}

}
