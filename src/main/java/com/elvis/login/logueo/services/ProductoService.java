package com.elvis.login.logueo.services;

import com.elvis.login.logueo.models.Categoria;
import com.elvis.login.logueo.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    //Implemntamos un método para obtener el producto por
    //id
    Optional<Producto> porId(Integer id);
    //Implementamos un meotod para guardar
    void guardar(Producto producto);
    //Implementamos un mpetodo para eliminar
    void eliminar(Integer id);
    //Implementamos un metodo para listar la Categoria
    List<Categoria> listarCategoria();
    //Implementamos un metodo para obtener el Id de la Categoria
    Optional<Categoria> porIdCategoria(Integer id);


}