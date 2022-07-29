<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- c:out ; c:forEach etc. -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <h1><c:out value="${box.title}"/></h1>
        <table class="table table-bordered table-hover">
        	<c:forEach var="team" items="${box.teams}">
		    	<tr>
		        	<td><a href="/team/${team.id}"><c:out value="${team.title}"/></a></td>
		        	<td>*add pokemon-pic</td>
		        	<td>*add pokemon-pic</td>
		        	<td>*add pokemon-pic</td>
		        	<td>*add pokemon-pic</td>
		        	<td>*add pokemon-pic</td>
		        	<td>*add pokemon-pic</td>
		    	</tr>
		    </c:forEach>
		</table>
    </body>

    </html>