<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Film By Id</title>
</head>
<body>

	<!-- Added this - Kenny -->	
	<h3>Find Film By Id</h3>
  		<form action="findFilmById.do" method="GET">
    	Film ID: 
   	 	<input type="text" name="title"/> 
    	<input type="submit" value="Get Film" />
  	</form>
  	
  	<p>Film info will show here:</p>
  	<p>${film.title}</p>

</body>

</html>