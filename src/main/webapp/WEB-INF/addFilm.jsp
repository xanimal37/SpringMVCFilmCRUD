<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mr. CRUD - Add a Film</title>
</head>
<body>
<h2>Add a Film</h2>
 <form action="addFilm.do" method="POST">
 	<label for="film_title">Title:</label>
     <input type="text" name="film_title" /><br />
     <label for="film_desc">Description:</label>
     <input type="text" name="film_desc" /><br />
     <label for="film_year">Release Year:</label>
     <input type="text" name="film_year"/><br />
     <label for="film_year">Release Year:</label>
     <input type="text" name="film_year"/><br />
     <!--  CHECKBOX for FEATURES (pick more than one) -->
     <!--  'Trailers','Commentaries','Deleted Scenes','Behind the Scenes' -->
     <p>Special Features:</p>
     <input type="checkbox" id="trailers" name="trailers" value="Trailers">
	<label for="trailers"> Trailers</label><br>
	<input type="checkbox" id="commentaries" name="commentaries" value="Commentaries">
	<label for="commentaries"> Commentaries</label><br>
	<input type="checkbox" id="deleted" name="deleted" value="Deleted Scenes">
	<label for="deleted"> Deleted Scenes</label><br>
     <input type="checkbox" id="behind" name="behind" value="Behind the Scenes">
	<label for="behind"> Behind the Scenes</label><br>
     <!--  RADIO BUTTONS for RATING (can only pick one) -->
     <p>Rating</p>
     <input type="radio" id="g" name="rating" value="G">
	<label for="g">G</label><br>
	<input type="radio" id="pg" name="rating" value="PG">
	<label for="pg">PG</label><br>
	<input type="radio" id="pg13" name="rating" value="PG13">
	<label for="pg13">PG-13</label><br>
	<input type="radio" id="r" name="rating" value="R">
	<label for="r">R</label><br>
	<input type="radio" id="nc17" name="rating" value="NC17">
	<label for="nc17">NC-17</label><br>
     
     <input type="submit" value="Submit" /><br />
   </form>

</body>
</html>