package com.feedfet.backend.service;

import java.util.List;
import java.util.Optional;

import com.feedfet.backend.entity.MetodoPago;

public interface MetodoPagoService {

    public List<MetodoPago> getAll(); // Get all payment methods

    public Optional<MetodoPago> getById(Long id); // Get payment method by ID

    public MetodoPago save(MetodoPago metodoPago); // Save a payment method

    public void delete(Long id); // Delete a payment method by ID

}
