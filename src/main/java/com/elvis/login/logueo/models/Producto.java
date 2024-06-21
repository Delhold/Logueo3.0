package com.elvis.login.logueo.models;

public class Producto {
    private Integer idProducto;
    private String nombre;
    private Categoria categoria;
    private String descripcion;
    private double precio;
    //Implementamos elconstructor
    public Producto(){

    }
    //Constructor qeu inicializa los parametros
    public Producto(Integer idProducto, String nombre, Categoria categoria, String descripcion, double precio){
        this.idProducto=idProducto;
        this.nombre=nombre;
        this.categoria=categoria;
        this.descripcion=descripcion;
        this.precio=precio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

