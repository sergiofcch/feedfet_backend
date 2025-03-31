package com.feedfet.backend.service;

import java.util.List;
import java.util.Optional;

import com.feedfet.backend.entity.Estado;

public interface EstadoService {
    List<Estado> getAll(); // Retrieves all Estado entities

    Optional<Estado> getById(Long id); // Retrieves an Estado entity by its ID

    Estado save(Estado estado); // Saves a new Estado entity or updates an existing one

    void delete(Long id); // Deletes an Estado entity by its ID
}

