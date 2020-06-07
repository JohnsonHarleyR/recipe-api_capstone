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
	
	<article class="card" id="advanced"  style="width: 25rem;">
		<article class="card-header"> 
			<h1>Search for a Recipe</h1>
		</article>
		<article class="card-body">
			<!-- Search bar -->
			<form  class= "search" action="/advanced-search">
				<section class="whole">
				<article class="adv" id="diet">
					<input type="hidden" name="fromNum" value="0">
					<label><b>Diet: </b></label><br>
				
					<label>balanced</label>
					<input type="radio" name="diet" value="balanced"/>
					<label>high fiber</label>
					<input type="radio" name="diet" value="high-fiber"/>
					<label>high protein</label>
					<input type="radio" name="diet" value="high-protein"/>
					<br>
					<label>low carb</label>
					<input type="radio" name="diet" value="low-carb"/>
					<label>low fat</label>
					<input type="radio" name="diet" value="low-fat"/>
					<label>low sodium</label>
					<input type="radio" name="diet" value="low-sodium"/>
					<label>none</label>
					<input type="radio" name="diet" value=""/>
				
				</article>
				
				<article class="adv" id="health">
				
					<label><b>Health: </b></label><br>
					
					<label>vegetarian</label>
					<input type="radio" name="health" value="vegetarian"/>
					<label>vegan</label>
					<input type="radio" name="health" value="vegan"/>
					<label>dairy free</label>
					<input type="radio" name="health" value="dairy-free"/>
					<br>
					<label>gluten free</label>
					<input type="radio" name="health" value="gluten-free"/>
					<label>keto friendly</label>
					<input type="radio" name="health" value="keto-friendly"/>
					<label>kosher</label>
					<input type="radio" name="health" value="kosher"/>
					<br>
					<label>no oils added</label>
					<input type="radio" name="health" value="no-oils-added"/>
					<label>low sugar</label>
					<input type="radio" name="health" value="low-sugar"/>
					<label>paleo</label>
					<input type="radio" name="health" value="paleo"/>
					<br>
					<label>none</label>
					<input type="radio" name="health" value=""/>
				
				</article>
				
				<article class="adv" id="calories">
					<label><b>Calories: </b></label><br>
					
					<label>Min:</label>
					<input id="small1" type="text" name="min" value="0"/>
					<label>Max:</label>
					<input id="small2" type="text" name="max" value="5000"/>
				</article>
				
				
				
						
				
				
					
				
			
				<article class="adv" id="search">
					<br>
					<label>Results per page:</label>
					<input id="small3" type="text" name="toNum" value="10"/><br>
					<label><b>Keyword:</b></label>
					<input type="search" name="keyword" required/>
					<br>
					<label>Exclude:</label>
					<input type="text" name="excluded"/>
					<br>
				</article>
				
				<button class="btn btn-light btn-lg" type="submit">Search</button>
			</section>
			</form>
	</article>
</article>
</main>

</body>
</html>