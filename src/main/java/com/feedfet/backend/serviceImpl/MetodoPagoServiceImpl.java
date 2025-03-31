package com.feedfet.backend.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feedfet.backend.entity.MetodoPago;
import com.feedfet.backend.repository.MetodoPagoRepository;
import com.feedfet.backend.service.MetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository; // Repository for payment methods

    @Override
    @Transactional(readOnly = true)
    public List<MetodoPago> getAll() {
        return metodoPagoRepository.findAll(); // Get all payment methods
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MetodoPago> getById(Long id) {
        return metodoPagoRepository.findById(id); // Get payment method by ID
    }

    @Override
    @Transactional
    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago); // Save a payment method
    }

    @Override
    @Transactional
    public void delete(Long id) {
        metodoPagoRepository.deleteById(id); // Delete a payment method by ID
    }

}
