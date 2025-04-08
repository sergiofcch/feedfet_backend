package com.feedfet.backend.controller;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedfet.backend.entity.Usuario;
import com.feedfet.backend.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.getAll();
    }

    @PostMapping
    public Usuario save(@RequestBody @Valid Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable("id") Long id, @RequestBody @Valid Usuario usuario) {
        Usuario usuarioExistente = usuarioService.getById(id).orElse(null);
        if (usuarioExistente == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellidos(usuario.getApellidos());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setPassword(usuario.getPassword());
        usuarioExistente.setRol(usuario.getRol());

        
        usuarioService.save(usuarioExistente);
        return ResponseEntity.ok(usuarioExistente);
    }

    @GetMapping("/email/{email}")
    public Usuario findByEmail(@RequestBody @Valid String email) {
        return usuarioService.findByEmail(email);
    }

    @GetMapping("/{id}")
    public Usuario getById(@RequestBody @Valid Long id) {
        return usuarioService.getById(id).orElse(null);
    }
    @PostMapping("/delete/{id}")
    public void delete(@RequestBody @Valid Long id) {
        usuarioService.delete(id);
    }

    //Validacion de usuario y contraseña mediante metodo POST
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
        if (usuarioExistente != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Usuario Autorizado"); // OK
        } else {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }

    

}
