<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>H�roe | Participaciones</title>
</head>
<body>
	<h1>Listando participaciones de <c:out value="${heroe.nombre}" />!</h1>
	<a href="participacion?action=agregar"><button>Agregar participaci�n</button></a>
	<table>
		<thead>
			<th>Nombre</th>
			<th>Lanzamiento</th>
			<th>A�o secuela</th>
			<th>Sin�psis</th>
			<th>Clasificaci�n</th>
		</thead>
		<tbody>
			<c:forEach var="pelicula" items="${peliculas}">
				<tr>
					<th><c:out value="${pelicula.nombre}" /></th>
					<th><c:out value="${pelicula.anolanzamiento}" /></th>
					<th><c:out value="${pelicula.anosecuencia}" /></th>
					<th><c:out value="${pelicula.sinopsis}" /></th>
					<th><c:out value="${pelicula.clasificacionBean.descripcion}" /></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>