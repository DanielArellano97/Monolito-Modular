package com.dani.api_restful.pedido.repositorys;

import com.dani.api_restful.pedido.entitys.Pedido;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, ObjectId>, PedidoRepositoryCustom {
}
