package com.dani.api_restful.producto.repositorys;

import com.dani.api_restful.producto.entitys.Producto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository <Producto, ObjectId> {
}
