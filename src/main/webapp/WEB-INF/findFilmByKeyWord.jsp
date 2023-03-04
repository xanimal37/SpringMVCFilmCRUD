<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Film by Keyword</title>
</head>
<body>

	<!-- Added this - Kenny -->	
	<h3>Find Actor By Film Id</h3>
  		<form action="findFilmByKeyWord.do" method="GET">
    	Film ID: 
   	 	<input type="text" name="title"/> 
    	<input type="submit" value="Get Film" />
  	</form>
  	
  	<p>Film info will show here:</p>
  	<p>${film.title}</p>

</body>
</html>