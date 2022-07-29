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
<title>Edit Pokemon Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/team.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="NavBar.jsp" />
	<div class="container">
		<div class="row mt-4">
			<h1 class="text-primary text-align-center">Edit ${pokemon.name}</h1>
		</div>
		<div class="card">

			<div class="card-header">Pokemon in Team</div>
			<div class="card-body">
				<form:form action="/pokemon/${pokemon.id}/update" method="post" modelAttribute="pokemon">
					<div class="form-group row">
						<div class="col-sm-1">
							<div><form:label path="name" class="col-form-label">Name:</form:label></div>
							<div><form:errors path="name" class="text-danger" /></div>
						</div>
						<div class="col-sm-11">
						<form:input path="name" name="name" class="form-control" />
						</div>
					</div>
					<div class="text-right">
						<input type="submit" class="btn btn-info mt-3" value="Submit" />
					</div>
				</form:form>
				<div class="btn-group btn-sm float-end">
					<a href="/team/{id}" class="btn btn-info me-3" role="button">Cancel</a>
				</div>

			</div>
		</div>
	</div>
</body>
</html>