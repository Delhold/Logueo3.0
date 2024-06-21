package com.elvis.login.logueo.repositories;

import com.elvis.login.logueo.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryJdbcImplement implements Repository{
    private Connection conn;

    public CategoriaRepositoryJdbcImplement(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List listar() throws SQLException {
        List <Categoria> categorias = new ArrayList<>();
        try(Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM categoria");
            while (rs.next()) {
                Categoria categoria = getCategoria(rs);
                categorias.add(categoria);
            }

        }
        return categorias;
    }

    @Override
    public Object porId(Integer id) throws SQLException {
        Categoria categoria = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categoria WHERE idcategoria = ?")) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    categoria = getCategoria(rs);
                }
            }
            return categoria;

        }

    }

    @Override
    public void guardar(Object o) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {

    }

    @Override
    public Object activar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public Object desactivar(Integer id) throws SQLException {
        return null;
    }
    private Categoria getCategoria(ResultSet rs) throws SQLException {
        Categoria  categoria = new Categoria();
        categoria.setNombre(rs.getString("nombre"));
        categoria.setIdCategoria(rs.getInt("idcategoria"));
        return categoria;
    }
}
