package com.feedfet.backend.service;

import java.util.List;
import java.util.Optional;

import com.feedfet.backend.entity.Usuario;

public interface UsuarioService {

    List<Usuario> getAll();

    Optional<Usuario> getById(Long id);

    Usuario save(Usuario usuario);

    void delete(Long id);

    Usuario findByEmail(String email);
}
