package com.elvis.login.logueo.repositories;

import com.elvis.login.logueo.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryImplement implements Repository<Categoria>{
    private Connection conn;

    public CategoriaRepositoryImplement(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias= new ArrayList<>();
        try (Statement stmt= conn.createStatement();
             ResultSet rs=stmt.executeQuery("select * from categoria")){
            while (rs.next()){
                Categoria categoria = getCategoria(rs);
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    @Override
    public Categoria porId(Integer id) throws SQLException {
        Categoria categoria= null;
        try (PreparedStatement stmt = conn.prepareStatement("select * from categoria where idcategoria=?")){
            stmt.setInt(1,id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    categoria=getCategoria(rs);
                }
            }

        }
        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {

    }

    @Override
    public Categoria activar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public Categoria desactivar(Integer id) throws SQLException {
        return null;
    }

    private Categoria getCategoria(ResultSet rs)throws SQLException{
        Categoria categoria = new Categoria();
        categoria.setNombre(rs.getString("nombre"));
        categoria.setIdCategoria(rs.getInt("idcategoria"));
        return categoria;
    }
}