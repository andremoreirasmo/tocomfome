package com.tocomfome.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tocomfome.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public abstract Optional<Usuario> findByEmail(String email);
}
