package com.dani.api_restful.usuario.controllers;
import com.dani.api_restful.usuario.entitys.Usuario;
import com.dani.api_restful.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuario")
class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/agregarUsuario")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/listaUsuarios")
    public List<Usuario> buscarUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/buscarUsuario/{rut}")
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable String rut) {
        return usuarioService.findById(rut);
    }

    @PatchMapping("/editarUsuario/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable String id, @RequestBody String nombre) {
        Optional<Usuario> userRepo = usuarioService.findById(id);
        Usuario usuario = null;
        if(userRepo.isPresent()){
            usuario = userRepo.get();
            usuario.setNombre(nombre);
        }
        usuarioService.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @RequestMapping("/eliminarUsuario/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        usuarioService.deleteById(id);
    }
}

