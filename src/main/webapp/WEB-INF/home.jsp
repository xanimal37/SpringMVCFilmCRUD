<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Site</title>
</head>
<body>

	<h1>Welcome to Mr. CRUD's Film Site!</h1>
	<h1>${TESTFILM.title}</h1>
	
	<!-- Added this - Kenny -->
	<!-- this was right! just need to use do instead of jsp -->
	<a href="findFilmById.do">Find film by Id</a><br/>
	
	<a href="findActorById.do">Find actor by Id</a><br/>
	
	<a href="findActorsByFilmId.do">Find actor by film Id</a><br/>
	
	<a href="findFilmByKeyWord.do">Find film by keyword</a><br/>
	
	<a href="createFilm.do">Add a film</a><br/>
	
	<a href="updateFilm.do">Update a film</a><br/>
	
	<a href="deleteFilm.do">Delete a film</a><br/>
	
</body>
</html>