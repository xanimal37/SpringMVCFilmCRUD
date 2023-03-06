<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mr. CRUD - Find Film by Keyword</title>
</head>
<body>
	<h1>Find Film(s) by Keyword</h1>
	<h2>Search</h2>
	<form action="findFilmByKeyword.do" method="GET">
		<input type="text" name="keyword" /><br /> <label for="keyword">KEYWORD:</label>
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
					<li><a href="findFilmById.do?id=${film.id}"><c:out value="${film}" /></a></li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>

</body>
</html>