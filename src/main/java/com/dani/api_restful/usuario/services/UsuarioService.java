package com.dani.api_restful.usuario.services;

import com.dani.api_restful.usuario.entitys.Usuario;
import com.dani.api_restful.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(String id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario pedido) {
        return usuarioRepository.save(pedido);
    }

    public void deleteById(String id) {
        usuarioRepository.deleteById(id);
    }
}
