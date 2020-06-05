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
<form  class= "search" id="advanced" action="/advanced-search">
	
	<section id="diet">
		<input type="hidden" name="fromNum" value="0">
		<label><b>Diet: </b></label><br>
	
		<input type="radio" name="diet" value="balanced"/>
		<label>balanced</label>
		<input type="radio" name="diet" value="high-fiber"/>
		<label>high fiber</label>
		<input type="radio" name="diet" value="high-protein"/>
		<label>high protein</label>
		<input type="radio" name="diet" value="low-carb"/>
		<label>low carb</label>
		<br>
		<input type="radio" name="diet" value="low-fat"/>
		<label>low fat</label>
		<input type="radio" name="diet" value="low-sodium"/>
		<label>low sodium</label>
		<input type="radio" name="diet" value=""/>
		<label>none</label>
	
	</section>
	
	<section id="health">
	
		<label><b>Health: </b></label><br>
		
		<input type="radio" name="health" value="vegetarian"/>
		<label>vegetarian</label>
		<input type="radio" name="health" value="vegan"/>
		<label>vegan</label>
		<input type="radio" name="health" value="dairy-free"/>
		<label>dairy free</label>
		<input type="radio" name="health" value="gluten-free"/>
		<label>gluten free</label>
		<input type="radio" name="health" value="keto-friendly"/>
		<label>keto friendly</label>
		</br>
		<input type="radio" name="health" value="kosher"/>
		<label>kosher</label>
		<input type="radio" name="health" value="no-oils-added"/>
		<label>no oils added</label>
		<input type="radio" name="health" value="low-sugar"/>
		<label>low sugar</label>
		<input type="radio" name="health" value="paleo"/>
		<label>paleo</label>
		<input type="radio" name="health" value=""/>
		<label>none</label>
	
	</section>
	
	<section id="calories">
		<label><b>Calories: </b></label><br>
		
		<label>Min:</label>
		<input type="text" name="min" value="0"/>
		<label>Max:</label>
		<input type="text" name="max" value="5000"/>
		<br>
	</section>
	
	
	
			
	
	
		
	

	<section id="search">
		<label><b>Keyword:</b></label>
		<input type="search" name="keyword" required/>
		<br>
		<label>Exclude:</label>
		<input type="text" name="excluded"/>
		<br>
		<label>Results per page:</label>
		<input type="text" name="toNum" value="10"/>
	</section>
	
	<button class="" type="submit">Search</button>
</form>


</main>

</body>
</html>