package com.elvis.login.logueo.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository <T>{
    List<T> listar() throws SQLException;
    T porId(Integer id) throws SQLException;
    void guardar(T t) throws SQLException;
    void eliminar(Integer id) throws SQLException;
    T activar(Integer id) throws SQLException;
    T desactivar(Integer id) throws SQLException;

}
