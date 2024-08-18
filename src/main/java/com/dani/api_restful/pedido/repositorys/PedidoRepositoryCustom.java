package com.dani.api_restful.pedido.repositorys;

import com.dani.api_restful.pedido.entitys.Pedido;

import java.util.List;

public interface PedidoRepositoryCustom {

    List<Pedido> findPedidosByUsuario(String nombre);
}
