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
	<jsp:include page="NavBar.jsp" />
	<div class="container"> 
		<div class="row mt-4">
			<h1 class="text-primary text-align-center">Forum</h1>
		</div>
		<div class="row mt-4">
			<div>
				<c:choose>
					<c:when test="${discussions.size() == 0}">
						<div>No discussion posted yet!</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="discussion" items="${discussions}">
		                    <div class="d-flex">
								<div class="d-inline-block font-weight-bold">${discussion.user.name}:</div>
								<div class="d-inline-block ml-2">${discussion.message}<span class="text-muted small ml-2">[Posted at: ${discussion.createdAt}]</span></div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<c:if test="${totalPages > 1}">
					<div class="d-flex mt-4">
					  <c:if test="${currentPage > 0}">
					  	<div class="d-inline-block mr-3"><a href="/discussion?page=${currentPage-1}" class="text-decoration-none">&lt; Previous</a></div>
					  </c:if>
					  <c:if test="${currentPage < totalPages - 1}">
					  	<div class="d-inline-block"><a href="/discussion?page=${currentPage+1}" class="text-decoration-none">Next &gt;</a></div>
					  </c:if>
					</div>
				</c:if>
			</div>
			<c:if test="${userId != null}">
				<div class="mt-4">
					<form:form action="/discussion/submit?page=${currentPage}" method="post" modelAttribute="newDiscussion">
						<div class="form-group row">
							<div class="col-sm-1">
								<div><form:label path="message" class="col-form-label">Add post:</form:label></div>
								<div><form:errors path="message" class="text-danger" /></div>
							</div>
							<div class="col-sm-11">
							<form:textarea path="message" class="form-control" row="5" />
							</div>
						</div>
						<div class="text-right">
							<form:input type="hidden" value="${userId}" path="user"/>
							<input type="submit" class="btn btn-info mt-3" value="Submit" />
						</div>
					</form:form>
				</div>
			</c:if>
		</div>
	</div>

</body>
</html>