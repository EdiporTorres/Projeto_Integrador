package com.generation.econectar.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.econectar.model.Usuario;
import com.generation.econectar.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<Usuario> usuarioOptional = userRepository.findByUsuario(username);
	if (usuarioOptional.isEmpty()) {
		throw new UsernameNotFoundException("Usuario não encontrado!: "+ username);
	}
	Usuario usuario = usuarioOptional.get();
	
	return User.builder()
			.username(usuario.getEmail())
			.password(usuario.getSenha())
			.authorities(Collections.emptyList())
			.build();
}
}