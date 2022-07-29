<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="NavBar.jsp" />
	<h1 class="text-center">${team.title }</h1>
	<div class="container">
	<h3>Pokemon in Team</h3>
	<ul>
		<c:forEach var="pokemon" items="${team.pokemon }">
			<li>${pokemon.name }
			<a href="/pokemon/${pokemon.id }/delete">Remove from team</a>
			</li>
			
		</c:forEach>
	</ul>
	<h2>Add a pokemon</h2>
	<form:form action="/pokemon/add/${ team.id }" method="POST"
		modelAttribute="newPokemon" >
		<input type="hidden" name="_method" value="put">
		<table>
			<tbody>
				<tr>
					<td><form:label class="form-control" path="name">Name:</form:label></td>
					<td><form:errors path="name" class="text-danger" /></td>
					<td><form:input path="name" class="form-control"/></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Add Pokemon">
	</form:form>
</div>
</body>

</html>