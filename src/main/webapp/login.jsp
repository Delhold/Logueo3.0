<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingresando al Sistema</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Iniciar sesión</h1>
    <form action="/logueo_war/Login" method="post">
        <div class="form-group">
            <label for="username">Ingrese el nombre del usuario</label>
            <input type="text" name="username" id="username" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">Ingrese la contraseña</label>
            <input type="password" name="password" id="password" class="form-control">
        </div>
        <div>
            <input type="submit" value="Login" class="btn btn-primary">
        </div>
    </form>
</div>
</body>
</html>
