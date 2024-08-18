package com.dani.api_restful.producto.services;

import com.dani.api_restful.producto.repositorys.ProductoRepository;
import com.dani.api_restful.producto.entitys.Producto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(ObjectId id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto pedido) {
        return productoRepository.save(pedido);
    }

    public void deleteById(ObjectId id) {
        productoRepository.deleteById(id);
    }
}
