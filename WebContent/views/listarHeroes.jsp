<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar | Héroes</title>
</head>
<body>
	<h1>Listando Heroes!</h1>
	<table>
		<thead>
			<th>Nombre</th>
			<th>Héroe</th>
			<th>Estado</th>
			<th>Género</th>
			<th>Arma</th>
		</thead>
		<tbody>
			<c:forEach var="heroe" items="${heroes}">
				<tr>
					<th><c:out value="${heroe.nombre}" /></th>
					<th><c:out value="${heroe.heroe}" /></th>
					<th><c:out value="${heroe.estadoBean.descripcion}" /></th>
					<th><c:out value="${heroe.generoBean.descripcion}" /></th>
					<th><c:out value="${heroe.arma}" /></th>
					<th><a href="heroe?action=participacion&id=${heroe.id}">Participaciones</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>