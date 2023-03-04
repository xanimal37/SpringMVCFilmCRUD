<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Actor By Film Id</title>
</head>
<body>

	<!-- Added this - Kenny -->	
	<h3>Find Actor By Film Id</h3>
  		<form action="findActorsByFilmId.do" method="GET">
    	Film ID: 
   	 	<input type="text" name="title"/> 
    	<input type="submit" value="Get Actor" />
  	</form>
  	
  	<p>Actor info will show here:</p>
  	<p>${actor.firstName}</p>
  	<p>${actor.lastName}</p>

</body>
</html>