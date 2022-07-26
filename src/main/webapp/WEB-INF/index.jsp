<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"/>
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js" defer></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js" defer></script>
<script type="text/javascript" src="js/script.js" defer></script>
<style>
div .discussion:hover{
	background-color: #0D6EFD;
}
</style>
<title>Pokémon Team Builder</title>
</head>
<body>

	<div class="container"> 
		<div class="row mt-4">
			<h1 class="text-primary text-align-center"> Pokémon Team builder </h1>
		</div>
		<div class="row mt-5">
			<div class="col-7" onClick="window.location.href='/discussion'">
				<h2 class="text-primary">Forum</h2>
				<div class="discussion border border-dark p-2">
					<c:choose>
						<c:when test="${discussions.size() == 0}">
							<div>No discussion posted yet!</div>
						</c:when>
						<c:otherwise>
							<c:forEach var="discussion" items="${discussions}">
			                    <div class="d-flex">
									<div class="d-inline-block font-weight-bold">${discussion.user.name}:</div>
									<div class="d-inline-block ml-2">${discussion.message}</div>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="col-1"></div>
			<div class="col-4">
				<h2 class="row" style="color: rgb(200,0,64)">Register</h2>
				<form:form class="row form" action="/createUser" modelAttribute="newUser" method="post">
					<div class="row">
						<form:errors class="text-danger" path="name"/>
						<form:label class="row" path="name">
							Name:
							<form:input path="name"/>
						</form:label>
					</div>
					<div class="row">
						<form:errors class="text-danger" path="email"/>
						<form:label class="row" path="email">
							Email:
							<form:input path="email"/>
						</form:label>
					</div>	
					<div class="row">
						<form:errors class="text-danger" path="password"/>
						<form:label class="row" path="password">
							Password:
							<form:input type="password" path="password"/>
						</form:label>
					</div>	
					<div class="row">
						<form:errors class="text-danger" path="confirmation"/>
						<form:label class="row" path="confirmation">
							Confirm Password:
							<form:input type="password" path="confirmation"/>
						</form:label>
					</div>	
					<div class="span2">
						<button type="submit" class="btn btn-primary btn-block row my-3 ms-2 justify-content-end" style="background-color: rgb(200,0,64); border: rgb(200,0,64); width: 120px">Create User</button>
					</div>
				</form:form>
				<h2 class="row mt-5" style="color: rgb(0,200,128)">Login</h2>
				<form:form class="row form" action="/login" modelAttribute="newLogin" method="post">
					<div class="row">
						<form:errors class="text-danger" path="email"/>
						<form:label class="row" path="email">
							Email:
							<form:input path="email"/>
						</form:label>
					</div>	
					<div class="row">
						<form:errors class="text-danger" path="password"/>
						<form:label class="row" path="password">
							Password:
							<form:input type="password" path="password"/>
						</form:label>
					</div>	
					<div class="span2">
						<button type="submit" class="btn btn-primary btn-block row my-3 ms-2 justify-content-end" style="background-color: rgb(0,200,128); border: rgb(0,200,128); width: 80px">Login</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>