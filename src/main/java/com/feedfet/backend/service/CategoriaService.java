package com.feedfet.backend.service;

import java.util.List;
import java.util.Optional;

import com.feedfet.backend.entity.Categoria;

public interface CategoriaService {

    List<Categoria> getAll(); // Retrieves all Categoria entities

    Optional<Categoria> getById(Long id); // Retrieves a Categoria entity by its ID

    Categoria save(Categoria categoria); // Saves a new Categoria entity or updates an existing one

    void delete(Long id); // Deletes a Categoria entity by its ID

}
