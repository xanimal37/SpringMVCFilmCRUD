<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Film By Id</title>
</head>
<body>

	<div>
		<h3>Find Film By Id</h3>
		<form action="findFilmById.do" method="GET">
			Film ID: <input type="text" name="title" /> <input type="submit"
				value="Get Film" />
		</form>
		<p>Film info will show here:</p>
		<p>${film.title}</p>
	</div>
	<br>
	<div>
		<h3>Find Actor By Id</h3>
		<form action="findActorById.do" method="GET">
			Film ID: <input type="text" name="title" /> <input type="submit"
				value="Get Actor" />
		</form>
		<p>Actor info will show here:</p>
		<p>${actor.firstName}</p>
		<p>${actor.lastName}</p>
	</div>
	<br>
	<div>
		<h3>Find Actor By Film Id</h3>
		<form action="findActorsByFilmId.do" method="GET">
			Film ID: <input type="text" name="title" /> <input type="submit"
				value="Get Actor" />
		</form>

		<p>Actor info will show here:</p>
		<p>${actor.firstName}</p>
		<p>${actor.lastName}</p>
	</div>
	<br>
	<div>
		<h3>Find Actor By Film Id</h3>
		<form action="findFilmByKeyWord.do" method="GET">
			Film ID: <input type="text" name="title" /> <input type="submit"
				value="Get Film" />
		</form>
		<p>Film info will show here:</p>
		<p>${film.title}</p>
	</div>
	<br>
	<div>
		<h3>Create Film</h3>
		<form action="createFilm.do" method="POST">
			Title: 
			<input type="text" name="title"/>
			<br> Description: 
			<input type="text" name="description"/>
			<br> Release Year: 
			<input type="text" name="releaseYear"/>
			<br> Language ID: 
			<input type="text" name="languageId"/>
			<br> Length: 
			<input type="text" name="length"/>
			<br> Replacement Cost: 
			<input type="text" name="replacementCost"/>
			<br> Rental Duration: 
			<input type="text" name="rentalDuration"/>
			<br> Rental Rate: 
			<input type="text" name="rentalRate"/>
			<br> Rating: 
			<input type="text" name="rating"/>
			<br> Special Features: 
			<input type="text" name="features"/>
			<br> 
			<input type="submit" value="Create Film"/>
		</form>
	</div>
	<br>
	<div>
		<h3>Update Film</h3>
		<form action="updateFilm.do" method="POST">		
			<br> Film ID: 
			<input type="text" name="id" />
			<br> Title: 
			<input type="text" name="title"/>
			<br> Description: 
			<input type="text" name="description"/>
			<br> Release Year: 
			<input type="text" name="releaseYear"/>
			<br> Language ID: 
			<input type="text" name="languageId"/>
			<br> Length: 
			<input type="text" name="length"/>
			<br> Replacement Cost: 
			<input type="text" name="replacementCost"/>
			<br> Rental Duration: 
			<input type="text" name="rentalDuration"/>
			<br> Rental Rate: 
			<input type="text" name="rentalRate"/>
			<br> Rating: 
			<input type="text" name="rating"/>
			<br> Special Features: 
			<input type="text" name="features"/>
			<br> 
			<input type="submit" value="Update Film"/>
		</form>
	</div>
	<div>
	  <h3>Delete Film</h3>
        <form action="deleteFilm.do" method="POST">
           Film ID: 
           <input type="text" name="id"/>
           <br>
           <input type="submit" value="Delete Film" />
        </form>
	</div>

</body>

</html>