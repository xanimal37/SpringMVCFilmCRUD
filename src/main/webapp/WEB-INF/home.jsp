<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
  body {
    background-color: #f0d5a8;
  }
</style>
<head>
<meta charset="UTF-8">
<title>Film Site</title>
</head>
<body>

	<h1>Welcome to Mr. CRUD's Film Site!</h1>
<<<<<<< HEAD
	<!-- <h1>${TESTFILM.title}</h1> -->

	<!-- Added this - Kenny -->
	<!-- this was right! just need to use do instead of jsp -->
	<a href="findFilmById.do">Enter</a>
=======
	<p>What would you like to do?</p>
	<ul>
	<li><a href="findFilmById.do">Find film by ID</a></li>
	<li><a href="findFilmByKeyword.do">Find film(s) by keyword</a></li>
	<li><a href="addFilm.do">Add a Film</a></li>
	
	</ul>
	
>>>>>>> 6305c327f5489495687591ee675e9146e3673a2d
	

</body>
</html>