<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mr. CRUD - Find Film by ID</title>
</head>
<body>
<h1>Find Film by ID</h1>
<h2>Search</h2>
  <form action="findFilmById.do" method="GET">
     <input type="text" name="id" /><br />
     <label for="id">Film ID:</label>
     <input type="submit" value="Submit" /><br />
   </form>
   <h2>Result</h2>
   <c:if test="${empty film}">
     <p>Sorry, no film found with that ID.</p>
	</c:if>
	<c:if test="${not empty film}">
     <ul>
   			<li>${film.id}</li>
  	 		<li>${film.title}</li>
    		<li>${film.description}</li>
   		</ul>
</c:if>
</body>
</html>