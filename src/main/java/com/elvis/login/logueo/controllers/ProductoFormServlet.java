package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.models.Categoria;
import com.elvis.login.logueo.models.Producto;
import com.elvis.login.logueo.services.ProductoService;
import com.elvis.login.logueo.services.ProductoServiceJdbcImplment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/formulario")
public class ProductoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getServletContext().getAttribute("conn");
        ProductoService service = new ProductoServiceJdbcImplment(conn);
        Integer idCategoria;
        try{
            idCategoria = Integer.parseInt(req.getParameter("idCategoria"));
        }catch (NumberFormatException e){
            idCategoria = 0;
        }

        //Crear una clase de nuestro Producto
        Producto producto = new Producto();
        producto.setCategoria(new Categoria());
        if(idCategoria > 0){
            Optional<Producto> o = service.porId(idCategoria);
            if(o.isPresent()){
                producto = o.get();
            }
        }
        req.setAttribute("categorias", service.listarCategoria());
        req.setAttribute("producto", producto);
        getServletContext().getRequestDispatcher("/EditProductos.jsp").forward(req, resp);
    }
}
