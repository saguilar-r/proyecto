package com.springboot.siicoreapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.siicoreapp.models.entity.User;

import com.springboot.siicoreapp.models.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<User> ListarTodos() {
		// TODO Auto-generated method stub
		return (List<User>) usuarioRepository.findAll();
	}

	@Override
	public void guardar(User user) {
		
		String pass = user.getPassword();
		user.setPassword(passEncoder.encode(pass));
	
		System.out.println(user);
		
		usuarioRepository.save(user);

	}

	@Override
	public User buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);

	}

}
