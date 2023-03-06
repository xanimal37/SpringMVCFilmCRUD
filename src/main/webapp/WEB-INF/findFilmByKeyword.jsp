<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Mr. CRUD - Find Film by Keyword</title>
</head>
<body class="p-3">
	<h1>Find Film(s) by Keyword</h1>
	<a href="home.do">return to Mr. Crud's home</a>
	<h2>Search</h2>
	<form action="findFilmByKeyword.do" method="GET">
	<label for="keyword">Keyword:</label>
		<input type="text" name="keyword" />
		<input type="submit" value="Submit" /><br />
	</form>
	<h2>Result</h2>

	<c:choose>
		<c:when test="${empty films}">
			<p>No Films found</p>
		</c:when>
		<c:otherwise>
			<ul>

				<c:forEach var="film" items="${films}">
					<li class="p-1"><a href="findFilmById.do?id=${film.id}"><c:out value="${film}" /></a></li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>