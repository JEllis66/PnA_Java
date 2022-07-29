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
<link rel="stylesheet" href="/css/team.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="NavBar.jsp" />
	<h1 class="text-center">${team.title }</h1>
	<div class="container">
		<div class="card">
			<div class="card-header">Pokemon in Team</div>
			<div class="card-body">
				<ul>
					<c:forEach var="pokemon" items="${team.pokemon }">
						<!--  <li>${pokemon.name }<a href="/pokemon/${pokemon.id }/delete">Remove
								from team</a>
						</li> -->
						<li>${pokemon.name }
							<div class="btn-group">
								<div class="btn-group btn-sm float-end">
									<form:form action="/pokemon/${pokemon.id}/edit" method="get">
										<input type="submit" class="btn btn-secondary" value="Edit" />
									</form:form>
								</div>
								<div class="btn-sm float-end">
									<form:form action="/pokemon/${pokemon.id}/delete" method="get">
										<input type="hidden" name="_method" value="delete" />
										<input type="submit" class="btn btn-danger" value="Delete" />
									</form:form>
								</div>
							</div>
						</li>

					</c:forEach>
				</ul>
			</div>
			<div class="card-footer text-muted">Add more pokemon below</div>
		</div>
		<div class="card">
			<div class="card-header">Add a Pokemon to your team!</div>
			<div class="card-body">
				<form:form action="/pokemon/add/${ team.id }" method="POST"
					modelAttribute="newPokemon">
					<input type="hidden" name="_method" value="put">
					<table>
						<tbody>
							<tr>
								<td><form:label class="form-control" path="name">Name:</form:label></td>
								<td><form:errors path="name" class="text-danger" /></td>
								<td><form:input path="name" class="form-control" /></td>
							</tr>
						</tbody>
					</table>
					<input type="submit" value="Add Pokemon">
				</form:form>
			</div>
			<div class="card-footer text-muted">Pick your favorites</div>
		</div>




	</div>
</body>

</html>