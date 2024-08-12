package com.dani.api_restful.usuarios.controllers;
import com.dani.api_restful.usuarios.entitys.Usuario;
import com.dani.api_restful.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping("/agregar/{nombre}/{apellido}/{id}")
    public String agregarUsuario(@PathVariable String nombre, @PathVariable String apellido, @PathVariable String id) {
        return  "";
    }

    @RequestMapping("/usuarios")
    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    @RequestMapping("/buscar/{id}")
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable String id) {
        return usuarioRepository.findById(id);
    }

    @RequestMapping("/editar/{id}")
    public String editarUsuario(@PathVariable String id) {
        return "editar  usuario by id!" + id;
    }

    @RequestMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        usuarioRepository.deleteById(id);
    }
}

