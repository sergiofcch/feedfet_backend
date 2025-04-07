package com.feedfet.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedfet.backend.entity.Categoria;
import com.feedfet.backend.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService; 

    // Define your endpoints here, for example:
    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.getAll();
    }

    // Add other endpoints as needed, such as getById, save, delete, etc.
    @GetMapping("/{id}")
    public Categoria getById(@PathVariable ("id") Long id) {
        return categoriaService.getById(id).orElse(null);
    }

    @PostMapping
    public Categoria save(@RequestBody @Valid Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable("id") Long id, @RequestBody @Valid Categoria categoria) {
        Categoria categoriaExistente = categoriaService.getById(id).orElse(null);
        if (categoriaExistente == null) {
            return null; // or throw an exception
        }
        categoriaExistente.setDescripcion(categoria.getDescripcion());
        return categoriaService.save(categoriaExistente);
    }

    // Add other endpoints as needed, such as delete, etc.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        categoriaService.delete(id);
    }

}
