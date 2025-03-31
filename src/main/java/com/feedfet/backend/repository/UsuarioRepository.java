package com.feedfet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedfet.backend.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

}
