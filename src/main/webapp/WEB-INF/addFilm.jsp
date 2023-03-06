<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Mr. CRUD - Add a Film</title>
</head>
<body class="p-3">
<h1>Add a Film</h1>
<a href="home.do">return to Mr. Crud's home</a>

<div class="p-6">
 <form action="addFilm.do" method="POST">
 	<label for="film_title">Title:</label>
     <input type="text" name="film_title" /><br />
     <label for="film_desc">Description: </label>
     <input type="text" name="film_desc" /><br />
     <label for="film_year">Release Year: </label>
     <input type="text" name="film_year"/><br />
     <label for="film_length">Length (minutes): </label>
     <input type="text" name="film_length"/><br />
     <label for="film_repCost">Replacement Cost: </label>
     <input type="text" name="film_repCost"/><br />
     <label for="film_rate">Rental Rate: </label>
     <input type="text" name="film_rate"/><br />
     <label for="film_rentalDuration">Rental Duration (days): </label>
     <input type="text" name="film_rentalDuration"/><br />
     <label for="film_languageID">Language ID: </label>
     <input type="text" name="film_languageID"/><br />
     
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
     <input type="radio" id="g" name="rating" value="G" checked="checked">
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
   </div>
   <c:choose>
   <c:when test = "${not empty film}">
            <!--  display info of added film, including new auto id -->
            <p>Film added: ${film.title}</p>
         </c:when>
         <c:otherwise>
            <p>No film added.</p>
         </c:otherwise>
   </c:choose>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>