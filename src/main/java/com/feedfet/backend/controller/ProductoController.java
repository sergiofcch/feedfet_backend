package com.feedfet.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedfet.backend.entity.Producto;
import com.feedfet.backend.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> getProductosByCategoriaId(@PathVariable ("id") Long categoriaId) {
        return productoService.findByCategoriaId(categoriaId);
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id).orElse(null);
    }

    @PostMapping
    public Producto createProducto(@RequestBody @Valid Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable ("id") Long id, @RequestBody @Valid Producto producto) {
        // Verificar si el producto existe antes de actualizarlo
        Producto existingProducto = productoService.getProductoById(id).orElse(null);
        if (existingProducto == null) {
            return null; // O lanzar una excepción si prefieres
        }
        // Actualizar los campos del producto existente con los nuevos valores
        existingProducto.setNombre(producto.getNombre());
        existingProducto.setDescripcion(producto.getDescripcion());
        existingProducto.setCosto(producto.getCosto());
        existingProducto.setPrecio(producto.getPrecio());
        return productoService.save(producto);
    }


}
