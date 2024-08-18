package com.dani.api_restful.pedido.controllers;
import com.dani.api_restful.pedido.entitys.Pedido;
import com.dani.api_restful.pedido.services.PedidoServiceImpl;
import com.dani.api_restful.usuario.entitys.Usuario;
import com.dani.api_restful.usuario.services.UsuarioService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/pedido")
class PedidoController {

    @Autowired
    PedidoServiceImpl pedidoServiceImpl;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/agregarPedido")
    public ResponseEntity<Pedido> agregarPedido(@RequestBody Pedido pedido) {
        String rutUsuario = pedido.getRutUsuario();
        Optional<Usuario> usuario = usuarioService.findById(rutUsuario);
        List<Pedido> pedidoUsuario = List.of(pedido);
        if(usuario.isPresent() && usuario.get().getPedido().isEmpty()){
            usuario.get().setPedido(pedidoUsuario);
            usuarioService.save(usuario.get());
        }else{
            List<Pedido> pedidosGuardados = usuario.get().getPedido();
            usuario.get().setPedido(Stream.concat(pedidosGuardados.stream(), pedidoUsuario.stream()).collect(Collectors.toList()));
            usuarioService.save(usuario.get());
        }
        pedidoServiceImpl.save(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @GetMapping("/listaPedidos")
    public List<Pedido> listarPedidos() {
        return pedidoServiceImpl.findAll();
    }

    @GetMapping("/buscarPedido/{id}")
    public Optional<Pedido> buscarPedidoById(@PathVariable ObjectId id) {
        return pedidoServiceImpl.findById(id);
    }

    @PatchMapping("/editarPedido/{id}")
    public ResponseEntity<Pedido> editarProducto(@PathVariable ObjectId id, @RequestBody int total) {
        Optional<Pedido> pedidoRepo = pedidoServiceImpl.findById(id);
        Pedido pedido = null;
        if(pedidoRepo.isPresent()){
            pedido = pedidoRepo.get();
            pedido.setTotal(total);
        }
        pedidoServiceImpl.save(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @RequestMapping("/eliminarPedido/{id}")
    public void eliminarPedido(@PathVariable ObjectId id) {
        pedidoServiceImpl.deleteById(id);
    }
}

