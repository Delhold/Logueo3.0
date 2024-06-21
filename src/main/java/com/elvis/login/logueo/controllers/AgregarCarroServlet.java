package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.models.Carro;
import com.elvis.login.logueo.models.ItemCarro;
import com.elvis.login.logueo.models.Producto;
import com.elvis.login.logueo.services.ProductoService;
import com.elvis.login.logueo.services.ProductoServiceImplement;

import com.elvis.login.logueo.services.ProductoServiceJdbcImplment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn= (Connection) req.getAttribute("conn");
        ProductoService service= new ProductoServiceJdbcImplment(conn);
        Integer idProdudto = Integer.parseInt(req.getParameter("id"));


        Optional<Producto> producto = service.porId(idProdudto);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            //Obtenemos la sesion
            HttpSession session = req.getSession();
            Carro carro;
            if (session.getAttribute("carro") == null) {
                carro = new Carro();
                session.setAttribute("carro", carro);
            }else{
                carro=(Carro) session.getAttribute("carro");
            }
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath()+ "/ver-carro");

    }
}