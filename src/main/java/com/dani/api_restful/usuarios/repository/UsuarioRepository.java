package com.dani.api_restful.usuarios.repository;

import com.dani.api_restful.usuarios.entitys.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
