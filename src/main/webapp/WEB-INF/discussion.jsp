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
<title>Pokémon Team builder - Forum</title>
</head>
<body>

	<div class="container"> 
		<div class="row mt-4">
			<h1 class="text-primary text-align-center">Forum</h1>
		</div>
		<div class="row mt-4">
			<div class="row mt-3 d-flex justify-content-evenly">
				<div class="col-13">
					<table class="table table-borderless">
						<tbody>
							<c:forEach var="discussion" items="${discussions}">
								<tr>
									<td class="align-middle">${discussion.createdAt}</td>
									<td class="align-middle font-weight-bold">${discussion.user.name}: </td>
									<td class="align-middle">${discussion.message}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div>
				  <c:if test="${currentPage > 0}"><span><a href="/discussion?page=${currentPage-1}">Previous Page</a></span></c:if>
				  <c:if test="${currentPage < totalPages - 1}"><span><a href="/discussion?page=${currentPage+1}">Next Page</a></span></c:if>
				</div>
			</div>
			<c:if test="${userId != null}">
				<div>
					<form:form action="/discussion/submit?page=${currentPage}" method="post" modelAttribute="newDiscussion">
						<div class="form-group pt-3">
							<form:label path="message">Add post:</form:label>
							<form:errors path="message" class="text-danger" />
							<form:textarea path="message" class="form-control" row="5" />
						</div>
							<!-- hidden -->
							<form:input type="hidden" value="${userId}" path="user"/>
						<div>
							<input type="submit" class="btn btn-info mt-3" value="Submit" />
						</div>
					</form:form>
				</div>
			</c:if>
		</div>
	</div>

</body>
</html>