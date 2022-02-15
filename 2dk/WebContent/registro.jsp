<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form method='post' action="">
		<h1>Registro de usuario</h1>
		<p>Nombre de usuario</p>
		<input name='nombre' type='text'>
		<p>Contraseña</p>
		<input name='contrasenia' type='password'>
		<p>Repetir Contraseña</p>
		<input name='contrasenia2' type='password'> 
		<input type='submit'>
		<% out.print(request.getAttribute("contraseniaMal")); %>
	</form>
	<a href='login'>Iniciar sesion</a>
</body>
</html>