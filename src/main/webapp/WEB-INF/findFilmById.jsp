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
	<a href="home.do">return to Mr. Crud's home</a>
	<h2>Search</h2>
	<form action="findFilmById.do" method="GET">
		<input type="text" name="id" /><br /> <label for="id">Film
			ID:</label> <input type="submit" value="Submit" /><br />
	</form>
	<h2>Result</h2>
	<c:if test="${empty film}">
		<p>Sorry, no film found with that ID.</p>
	</c:if>
	<c:if test="${not empty film}">
	<p>Film ID: ${film.id}</p>
  <form action="findFilmById.do?id=${film.id}" method="POST">
 	<label for="film_title">Title:</label>
     <input type="text" name="film_title" size="50" value="${film.title}"/><br />
     <label for="film_desc">Description: </label>
     <input type="text" name="film_desc" size="110" value="${film.description}"/><br />
     <label for="film_year">Release Year: </label>
     <input type="text" name="film_year" size="4" value="${film.releaseYear}"/><br />
     <label for="film_length">Length (minutes): </label>
     <input type="text" name="film_length" size="6" value="${film.length}"/><br />
     <label for="film_repCost">Replacement Cost: </label>
     <input type="text" name="film_repCost" size="10" value="${film.replacementCost}"/><br />
     <label for="film_languageID">Language ID: </label>
     <input type="text" name="film_languageID" size="1" value="${film.languageId}"/><br />
     <label for="film_rate">Rental Rate: </label>
     <input type="text" name="film_rate" size="10" value="${film.rentalRate}"/><br />
     <label for="film_rentalDuration">Rental Duration (days): </label>
     <input type="text" name="film_rentalDuration" size="6" value="${film.rentalDuration}"><br />
     <p>** Starring **</p>
     <ul>
     <c:forEach var="actor" items="${film.actors}">
     	<li>${actor}</li>
     	</c:forEach>
     </ul>
     <p>For special features, enter [Trailers, Commentaries, Behind the Scenes, Deleted Scenes] separated by commas with no spaces.</p>
     <label for="film_features">Features: </label>
     <input type="text" name="film_features" size="40" value="${film.features}"/><br />
     <p>For Rating, enter ONE of the following: [G] [PG] [PG13] [R] [NC17]</p>
     <label for="film_rating">Rating: </label>
     <input type="text" name="film_rating" size="3" value="${film.rating}"/><br />
  
     <input type="submit" name="update" value="Update" /><br />
      <input type="submit" name="delete" value="Delete" /><br />
			
   </form>
  
		
	</c:if>
	<p>${message}</p>
</body>
</html>