package com.feedfet.backend.service;


import java.util.List;
import java.util.Optional;

import com.feedfet.backend.entity.Producto;

public interface ProductoService {

    List<Producto> getAllProductos();

    Optional<Producto> getProductoById(Long id);

    Producto save(Producto producto);

    void deleteById(Long id);

// Listar producto por categoria
    List<Producto> findByCategoriaId(Long categoriaId); // Cambiado a Long para que coincida con el tipo de id en Categoria
  
}
