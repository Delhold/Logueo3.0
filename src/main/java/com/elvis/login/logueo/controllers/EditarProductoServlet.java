package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.models.Producto;
import com.elvis.login.logueo.models.Categoria;
import com.elvis.login.logueo.repositories.Repository;
import com.elvis.login.logueo.repositories.ProductoRepositoryJdbcImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/editar-producto")
public class EditarProductoServlet extends HttpServlet {
    private Repository<Producto> productoRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) request.getAttribute("conn");
        productoRepository = new ProductoRepositoryJdbcImpl(conn);
        int idProducto = Integer.parseInt(request.getParameter("idarticulo"));
        String nombre = request.getParameter("nombre");
        int idCategoria = Integer.parseInt(request.getParameter("categoria"));
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto.setNombre(nombre);
        producto.setCategoria(categoria);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);



        try {
            productoRepository.guardar(producto);
            response.sendRedirect(request.getContextPath() + "/verProductos.jsp");
        } catch (Exception e) {
            throw new ServletException("Error al actualizar el producto", e);
        }
    }
}
