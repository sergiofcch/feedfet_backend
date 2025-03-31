package com.feedfet.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedfet.backend.entity.Estado;
import com.feedfet.backend.service.EstadoService;

@RestController
@RequestMapping("api/estado")
@CrossOrigin(origins = "*")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> getAll() {
        return estadoService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> save(Estado estado) {
        Estado savedEstado = estadoService.save(estado);
        return ResponseEntity.ok(savedEstado);
    }
    

}
