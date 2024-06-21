<%@ page import="com.elvis.login.logueo.models.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.Map" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<Categoria> categorias=(List<Categoria>) request.getAttribute("categorias");
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    Producto producto = (Producto) request.getAttribute("producto");
    Optional<String> username = (Optional<String>) request.getAttribute("username");
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de productos</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<h2>Listado de productos</h2>
<% if (username.isPresent()) { %>
<div>Hola <%= username.get() %>, Bienvenido!</div>
<p><a href="<%= request.getContextPath() %>/formulario">Crear Nuevo Producto</a></p>
<% } %>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Categoría</th>
        <th>Descripción</th>
        <th>Precio</th>
        <th>Agregar</th>
        <th>Editar</th>
        <th>Eliminar</th>
    </tr>
    </thead>
    <tbody>
    <% for (Producto p : productos) { %>
    <tr>
        <td><%= p.getIdProducto() %></td>
        <td><%= p.getNombre() %></td>
        <td><%= p.getCategoria().getNombre() %></td>
        <td><%= p.getDescripcion() %></td>
        <td><%= p.getPrecio() %></td>
        <% if (username.isPresent()) { %>
        <td><a href="<%= request.getContextPath() %>/agregar-carro?id=<%= p.getIdProducto() %>">Agregar al carro</a></td>
        <td><a href="<%= request.getContextPath() %>/editar-producto?id=<%= p.getIdProducto() %>">Editar</a></td>
        <td><a onclick="return confirm('¿Estás seguro de que deseas eliminar el producto?');"
               href="<%= request.getContextPath() %>/eliminar-producto?id=<%= p.getIdProducto() %>">Eliminar</a></td>
        <% } %>
    </tr>
    <% } %>
    </tbody>
</table>
<footer>
    <p>&copy; 2024 Textileria App. Todos los derechos reservados.</p>
</footer>
</body>
</html>
