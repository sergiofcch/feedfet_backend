package com.feedfet.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedfet.backend.entity.MetodoPago;
import com.feedfet.backend.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodopago")
@CrossOrigin(origins = "*")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService; // Service for payment methods

    // Endpoint to get all payment methods
    @GetMapping
    public List<MetodoPago> getAll() {
        return metodoPagoService.getAll(); // Get all payment methods
    }

    // Endpoint to get payment method by ID
    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getById(@PathVariable ("id") Long id) {
        Optional<MetodoPago> metodoPago = metodoPagoService.getById(id); // Get payment method by ID
        if (metodoPago.isPresent()) {
            return ResponseEntity.ok(metodoPago.get()); // Return payment method if found
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }

    // Endpoint to save a new payment method
    @PostMapping
    public ResponseEntity<MetodoPago> save(@RequestBody MetodoPago metodoPago) {
        MetodoPago savedMetodoPago = metodoPagoService.save(metodoPago); 
        return ResponseEntity.ok(savedMetodoPago);
    }

}
