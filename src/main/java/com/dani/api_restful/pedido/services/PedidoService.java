package com.dani.api_restful.pedido.services;

import com.dani.api_restful.pedido.entitys.Pedido;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> findAll();

    Optional<Pedido> findById(ObjectId id);

    Pedido save(Pedido pedido);

    void deleteById(ObjectId id);
}
