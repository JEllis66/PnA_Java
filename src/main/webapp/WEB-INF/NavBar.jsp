<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- c:out ; c:forEach etc. -->
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
        <nav class="navbar navbar-expand-xl navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="/home">Team Builder</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarDark"
                    aria-controls="navbarDark" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse show" id="navbarDark">
                    <ul class="navbar-nav me-auto mb-2 mb-xl-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/my/boxes">Boxes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/poke/discussion">Forum</a>
                        </li>
                    </ul>
                    <a class="d-flex nav-link" href="/logout">Logout</a>
                </div>
            </div>
        </nav>
    </body>

    </html>