package com.elvis.login.logueo.models;

import java.util.Objects;

public class ItemCarro {
    //declaramos las variables del ItemCArro
    private int cantidad;
    private Producto producto;

    public ItemCarro() {
    }

    public ItemCarro(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarro itemCarro = (ItemCarro) o;
        return Objects.equals(producto.getIdProducto(), itemCarro.producto.getIdProducto())
                && Objects.equals(producto.getNombre(), itemCarro.producto.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, producto);
    }

    public double getImporte(){
        return cantidad* producto.getPrecio();
    }
}
