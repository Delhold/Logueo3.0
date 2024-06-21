package com.elvis.login.logueo.repositories;

import com.elvis.login.logueo.models.Producto;
import com.elvis.login.logueo.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository<Producto> {
    private Connection conn;

    public ProductoRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT a.idarticulo, a.idcategoria, a.codigo, a.nombre, a.stock, a.descripcion, a.imagen, a.condicion, a.precio, c.nombre as nombre_categoria " +
                "FROM articulo AS a " +
                "INNER JOIN categoria AS c ON a.idcategoria = c.idcategoria " +
                "ORDER BY a.codigo ASC";
        try (Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery(query)) {
            while (rs.next()) {
                Producto p = getProducto(rs);
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Integer id) throws SQLException {
        Producto producto = null;
        String query = "SELECT a.*, c.nombre AS nombre_categoria " +
                "FROM articulo AS a " +
                "INNER JOIN categoria AS c ON a.idcategoria = c.idcategoria " +
                "WHERE a.idarticulo = ?";
        try (PreparedStatement smt = conn.prepareStatement(query)) {
            smt.setInt(1, id);
            try (ResultSet rs = smt.executeQuery()) {
                if (rs.next()) {
                    producto = getProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getIdProducto() != null && producto.getIdProducto() > 0) {
            sql = "UPDATE articulo SET nombre=?, idcategoria=?, descripcion=?, precio=? WHERE idarticulo=?";
        } else {
            sql = "INSERT INTO articulo(nombre, idcategoria, descripcion, precio, estado) VALUES(?,?,?,?,1)";
        }
        try (PreparedStatement smt = conn.prepareStatement(sql)) {
            smt.setString(1, producto.getNombre());
            smt.setInt(2, producto.getCategoria().getIdCategoria());
            smt.setString(3, producto.getDescripcion());
            smt.setDouble(4, producto.getPrecio());
            if (producto.getIdProducto() != null && producto.getIdProducto() > 0) {
                smt.setInt(5, producto.getIdProducto());
            }
            smt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String sql = "DELETE FROM articulo WHERE idarticulo=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Producto activar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public Producto desactivar(Integer id) throws SQLException {
        return null;
    }

    private static Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setIdProducto(rs.getInt("idarticulo"));
        p.setNombre(rs.getString("nombre"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setPrecio(rs.getDouble("precio"));
        Categoria c = new Categoria();
        c.setIdCategoria(rs.getInt("idcategoria"));
        c.setNombre(rs.getString("nombre_categoria"));
        p.setCategoria(c);
        return p;
    }
}
