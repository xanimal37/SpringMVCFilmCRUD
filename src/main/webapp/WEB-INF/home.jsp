<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Film Site</title>
</head>
<body class="p-3">

	<h1>Welcome to Mr. CRUD's Film Site!</h1>
	<p>What would you like to do?</p>
	<ul>
	<li class="p-1"><a href="findFilmById.do">Find film by ID (Update or Delete)</a></li>
	<li class="p-1"><a href="findFilmByKeyword.do">Find film(s) by keyword</a></li>
	<li class="p-1"><a href="addFilm.do">Add a Film</a></li>
	</ul>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>