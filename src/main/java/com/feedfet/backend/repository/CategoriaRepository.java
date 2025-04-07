package com.feedfet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedfet.backend.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
