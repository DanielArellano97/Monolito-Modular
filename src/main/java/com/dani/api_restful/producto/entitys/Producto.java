package com.dani.api_restful.producto.entitys;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
@TypeAlias("producto")
public class Producto {

    @Id
    private ObjectId id;
    private String nombre;
    private int valor;

    public Producto(ObjectId id, String nombre, int valor){
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
