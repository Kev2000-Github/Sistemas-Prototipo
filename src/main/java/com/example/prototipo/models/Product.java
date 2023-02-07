package com.example.prototipo.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Product {
    private String codigo;
    private String nombre;
    private ImageView foto;
    private String descripcion;
    private float precio;

    public Product(){}

    public Product(
            String codigo,
            String nombre,
            ImageView foto,
            String descripcion,
            float precio
    ){
        this.codigo = codigo;
        this.nombre = nombre;
        this.foto = foto;
        this.descripcion = descripcion;
        this.precio = precio;
        foto.setFitWidth(50);
        foto.setFitHeight(50);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
