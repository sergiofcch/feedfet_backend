package com.feedfet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedfet.backend.entity.Estado;

public interface EstadoRepository extends JpaRepository <Estado, Long> {
    // No additional methods are needed for basic CRUD operations

}
