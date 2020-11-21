<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Heroe | Crear</title>
</head>
<body>
	<form action="heroe?action=crear" method="post">
		<div>
			<label>Nombre</label> <input name="nombre" placeholder="Nombre"
				required>
		</div>
		<div>
			<label>Héroe</label> <input name="heroe" placeholder="Héroe" required>
		</div>
		<div>
			<label>Fecha de naciomiento</label> <input name="fechanacimiento"
				type="date" required>
		</div>
		<div>
			<label>Fecha de aparción</label> <input name="fechaaparicion"
				type="date" required>
		</div>
		<div>
			<label>Género</label> <select name="genero">
				<c:forEach var="genero" items="${generos}">
					<option value="<c:out value="${genero.id}" />">
						<c:out value="${genero.descripcion}" />
					</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>Estado</label> <select name="estado">
				<c:forEach var="estado" items="${estados}">
					<option value="<c:out value="${estado.id}" />">
						<c:out value="${estado.descripcion}" />
					</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<input name="arma" placeholder="Arma" required>
		</div>
		<button type="submit">Crear!</button>
	</form>
</body>
</html>