package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.Usuario;
import com.springboot.siicoreapp.models.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> ListarTodos() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		usuarioRepository.save(usuario);

	}

	@Override
	public Usuario buscarPorId(Long id_usuario) {
		return usuarioRepository.findById(id_usuario).orElse(null);
	}

	@Override
	public void eliminar(Long id_usuario) {
		usuarioRepository.deleteById(id_usuario);

	}

}
