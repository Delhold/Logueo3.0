<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.elvis.login.logueo.models.*" %>
<%@ page import="com.elvis.login.logueo.models.Categoria" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.elvis.login.logueo.models.Producto" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categoria");
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    Producto producto=(Producto)request.getAttribute("producto");%>




<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Producto</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Crear Nuevo Producto</h1>

    <form action="<%= request.getContextPath() %>/formulario" method="post">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="categoria">Categoría:</label>
            <select id="categoria" name="categoria" class="form-control" required>
                <option value="">Selecciona una categoría</option>
                <% for (Categoria c: categorias) { %>
                <option value="<%= c.getIdCategoria()%>"><%= c.getNombre()%></option>
                <% } %>



            </select>
        </div>
        <div class="form-group">
            <label for="descripcion">Descripción:</label>
            <textarea id="descripcion" name="descripcion" class="form-control" rows="5" required></textarea>
        </div>
        <div class="form-group">
            <label for="precio">Precio:</label>
            <input type="number" id="precio" name="precio" class="form-control" min="0" step="0.01" required>
        </div>
        <button type="submit" class="btn btn-primary">Crear Producto</button>
    </form>

    <br>
    <p><a href="<%= request.getContextPath() %>/index.html" class="btn btn-secondary">Volver</a></p>
</div>
</body>
</html>