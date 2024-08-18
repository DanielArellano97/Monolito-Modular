package com.dani.api_restful.producto.controllers;
import com.dani.api_restful.producto.entitys.Producto;
import com.dani.api_restful.producto.services.ProductoService;
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

@RestController
@RequestMapping("api/producto")
class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("/agregarProducto")
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        productoService.save(producto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @GetMapping("/listaProductos")
    public List<Producto> buscarProducto() {
        return productoService.findAll();
    }

    @GetMapping("/buscarProducto/{id}")
    public Optional<Producto> buscarProdcutoById(@PathVariable ObjectId id) {
        return productoService.findById(id);
    }

    @PatchMapping("/editarProducto/{id}")
    public ResponseEntity<Producto> editarProducto(@PathVariable ObjectId id, @RequestBody int valor) {
        Optional<Producto> producRepo = productoService.findById(id);
        Producto producto = null;
        if(producRepo.isPresent()){
            producto = producRepo.get();
            producto.setValor(valor);
        }
        productoService.save(producto);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @RequestMapping("/eliminarProducto/{id}")
    public void eliminarProducto(@PathVariable ObjectId id) {
        productoService.deleteById(id);
    }

}

