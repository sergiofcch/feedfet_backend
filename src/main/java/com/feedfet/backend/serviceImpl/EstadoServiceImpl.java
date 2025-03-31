package com.feedfet.backend.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.feedfet.backend.entity.Estado;
import com.feedfet.backend.repository.EstadoRepository;
import com.feedfet.backend.service.EstadoService;

public class EstadoServiceImpl implements EstadoService {
    
    private final EstadoRepository estadoRepository;

    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public List<Estado> getAll() {
        return estadoRepository.findAll();
    }

    @Override
    public Optional<Estado> getById(Long id) {
        return estadoRepository.findById(id);
    }

    @Override
    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }



}
