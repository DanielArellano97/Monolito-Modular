package com.dani.api_restful.usuario.entitys;

import com.dani.api_restful.pedido.entitys.Pedido;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "usuario")
@TypeAlias("usuario")
public class Usuario {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private List<Pedido> pedido;

    public Usuario(String id, String nombre, String apellido, List<Pedido> pedido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pedido = pedido;
    }

    public String getRut() {
        return id;
    }

    public void setRut(String rut) {
        this.id = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public List<Pedido> getPedido() {
        return pedido;
    }
}
