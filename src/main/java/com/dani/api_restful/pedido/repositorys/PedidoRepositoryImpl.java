package com.dani.api_restful.pedido.repositorys;

import com.dani.api_restful.pedido.entitys.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class PedidoRepositoryImpl implements PedidoRepositoryCustom {


    private final MongoTemplate mongoTemplate;

    @Autowired
    public PedidoRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Pedido> findPedidosByUsuario(String usuario) {
        Query query = new Query();
        query.addCriteria(Criteria.where("nombre").regex(usuario, "i"));
        return mongoTemplate.find(query, Pedido.class);
    }
}
