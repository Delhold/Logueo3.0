<%@ page import="com.elvis.login.logueo.models.Producto" %>
<%@ page import="java.util.Optional" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Producto producto = (Producto) request.getAttribute("producto");
    Optional<String> username = (Optional<String>) request.getAttribute("username");
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Producto</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Editar Producto</h2>
    <% if (username.isPresent()) { %>
    <div>Hola <%= username.get() %>, Bienvenido!</div>
    <% } %>
    <form action="<%= request.getContextPath() %>/editar-producto" method="post">
        <input type="hidden" name="idProducto" value="<%= producto.getIdProducto() %>">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" class="form-control" value="<%= producto.getNombre() %>">
        </div>
        <div class="form-group">
            <label for="categoria">Categoría:</label>
            <input type="text" id="categoria" name="categoria" class="form-control" value="<%= producto.getCategoria().getIdCategoria() %>">
        </div>
        <div class="form-group">
            <label for="descripcion">Descripción:</label>
            <textarea id="descripcion" name="descripcion" class="form-control"><%= producto.getDescripcion() %></textarea>
        </div>
        <div class="form-group">
            <label for="precio">Precio:</label>
            <input type="text" id="precio" name="precio" class="form-control" value="<%= producto.getPrecio() %>">
        </div>
        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
    </form>
    <a href="<%= request.getContextPath() %>/verProductos.jsp" class="btn btn-secondary mt-3">Volver al Listado de Productos</a>
</div>
</body>
</html>
