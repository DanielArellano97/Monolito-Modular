package com.dani.api_restful.pedido.entitys;

import com.dani.api_restful.producto.entitys.Producto;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "pedidos")
@TypeAlias("pedido")
public class Pedido {

    @Id
    private ObjectId id;
    private List<Producto> productos;
    private int total;
    private String usuario;


    public Pedido(ObjectId id, List<Producto> productos, int total, String usuario){
        this.id = id;
        this.productos = productos;
        this.total = total;
        this.usuario = usuario;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getRutUsuario() {
        return usuario;
    }

    public void setRutUsuario(String usuario) {
        this.usuario = usuario;
    }
}
