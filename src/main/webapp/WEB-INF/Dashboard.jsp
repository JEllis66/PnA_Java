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
<title>Home Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/dashboard.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-xl navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/home">Team Builder</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarDark"
				aria-controls="navbarDark" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse show" id="navbarDark">
				<ul class="navbar-nav me-auto mb-2 mb-xl-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/my/boxes">Boxes</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/poke/discussion">Forum</a></li>
				</ul>
				<a class="d-flex nav-link" href="/logout">Logout</a>
			</div>
		</div>
	</nav>
	<h1 class="text-center">Hello ${ user.name }</h1>
	<div class="container d-flex justify-content-center">

		<div>
			<div class="d-flex justify-content-around">
				<div class="card" id="dashboard-card">
					<div class="card-header text-center">Hi, ${user.name }</div>
					<div
						class="card-body align-items-center d-flex justify-content-center">
						<h5 class="card-title">Build your dream team!</h5>
						<img src="${ user.profilePic.url }" height="400" width="300"
							alt="Profile Picture" />
					</div>
					<div class="card-footer text-muted">
						<form action="/pictures/profile/add" method="post"
							enctype="multipart/form-data">
							<div class="form-data">
								Add a profile picture: <input type="file" name="url" id="" />
							</div>
							<input type="submit" value="Upload"
								class="btn btn-primary float-end" />
						</form>
					</div>
				</div>
			</div>
		</div>
		<div>

			<div class="card">
				<div class="card-header">
					<ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
						<c:forEach var="box" items="${ boxes }">
							<li class="nav-item" role="presentation"><a class="nav-link"
								id="profile-tab" data-bs-toggle="tab" href="#profile" role="tab"
								aria-controls="profile" aria-selected="false">${ box.title }</a></li>
						</c:forEach>
						<li>
						<li class="nav-item" role="presentation"><a class="nav-link"
							id="profile-tab" href="/box/submit" role="tab"
							aria-controls="profile" aria-selected="false">+</a></li>
						</li>
					</ul>
				</div>
				<div class="card-body">
					<div class="tab-content" id="myTabContent">
						<c:forEach var="box" items="${ boxes }">
							<div class="tab-pane fade show active" id="profile"
								role="tabpanel" aria-labelledby="profile-tab">
								<c:forEach var="team" items="${ box.teams }">
									<ul>
										<c:forEach var="pokemon" items="${ team.pokemon }">
											<li>${ pokemon.name }</li>
										</c:forEach>
									</ul>
								</c:forEach>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>