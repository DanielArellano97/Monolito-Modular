package com.dani.api_restful.pedido.services;

import com.dani.api_restful.pedido.entitys.Pedido;
import com.dani.api_restful.pedido.repositorys.PedidoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {

        return pedidoRepository.findAll();
    }
    @Override
    public Optional<Pedido> findById(ObjectId id) {
        return pedidoRepository.findById(id);
    }
    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    @Override
    public void deleteById(ObjectId id) {
        pedidoRepository.deleteById(id);
    }
}
