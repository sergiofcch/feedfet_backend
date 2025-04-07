package com.feedfet.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedfet.backend.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
   
    // Método para listar productos por categoría
    List<Producto> findByCategoriaId(Long categoriaId);
}
