package com.dani.api_restful.usuarios.services;

import com.dani.api_restful.usuarios.entitys.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public String agregarUsuario(Usuario usuario){
        return "usuario agregado!!: " + usuario.nombre;
    }
}
