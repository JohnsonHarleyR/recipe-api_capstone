<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<!-- Header -->
<section class="header">
<%@ include file="partials/header.jsp" %>
</section>

<!-- MainBody -->
<main class="container">
<h1>Search for a Recipe</h1>

<!-- Search bar -->
<form  class= "search" id="advanced" action="/search"></form>
	
	<section id="diet">
		<label><b>Diet: </b></label><br>
	
		<input type="checkbox" name="diet[]" id="diet1" value="balanced"/>
		<label>balanced</label>
		<input type="checkbox" name="diet[]" id="diet2" value="high-fiber"/>
		<label>high fiber</label>
		<input type="checkbox" name="diet[]" id="diet3" value="high-fiber"/>
		<label>high fiber</label>
		<input type="checkbox" name="diet[]" id="diet4" value="high-protein"/>
		<label>high protein</label>
		<input type="checkbox" name="diet[]" id="diet5" value="low-carb"/>
		<label>low carb</label>
		<br>
		<input type="checkbox" name="diet[]" id="diet6" value="low-fat"/>
		<label>low fat</label>
		<input type="checkbox" name="diet[]" id="diet7" value="low-sodium"/>
		<label>low sodium</label>
	
	</section>
	
	<section id="health">
	
		<label><b>Health: </b></label><br>
		
		<input type="checkbox" name="health[]" id="health1" value="vegetarian"/>
		<label>vegetarian</label>
		<input type="checkbox" name="health[]" id="health2" value="vegan"/>
		<label>vegan</label>
		<input type="checkbox" name="health[]" id="health3" value="dairy-free"/>
		<label>dairy free</label>
		<input type="checkbox" name="health[]" id="health4" value="gluten-free"/>
		<label>gluten free</label>
		<input type="checkbox" name="health[]" id="health5" value="keto-friendly"/>
		<label>keto friendly</label>
		</br>
		<input type="checkbox" name="health[]" id="health6" value="kosher"/>
		<label>kosher</label>
		<input type="checkbox" name="health[]" id="health7" value="no-oils-added"/>
		<label>no oils added</label>
		<input type="checkbox" name="health[]" id="health8" value="low-sugar"/>
		<label>low sugar</label>
		<input type="checkbox" name="health[]" id="health9" value="paleo"/>
		<label>paleo</label>
	
	</section>
	
	<section id="calories">
		<label><b>Calories: </b></label><br>
		
		<label>Min:</label>
		<input type="text" name="min" value="0"/>
		<label>Max:</label>
		<input type="text" name="max" value="0"/>
	</section>
	
	<section id="perpage">
		<label>Results per page:</label>
		<input type="text" name="results" value="10"/>
	</section>
	

	
	<label>Keyword: </section>
	<input type="search" name="keyword" required/>
		
	
	
	<button class="" type="submit">Search</button>
</form>


</main>

</body>
</html>