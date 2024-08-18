package com.dani.api_restful.usuario.repository;

import com.dani.api_restful.usuario.entitys.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
