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
<title>Navigation</title>
</head>
<body>

<!-- Header -->
<section class="header">

</section>

<!-- MainBody -->
<main class="container">

<!-- Navigation Bar -->
<nav class="navbar navbar-custom">

	<ul class="nav">
	
		<li class="nav-item" >
			<c:choose>
				<c:when test="${loggedin == false}">
					<a class="nav-link" href="/login">Sign In</a>
				</c:when>
				<c:when test="${loggedin == true}">
				<a id="hello" class="nav-link" href="/user-info"><c:out value="Hello, ${user.name}!"/></a>
				</c:when>
			</c:choose>
		</li>
		<li class="nav-item">
			<c:choose>
				<c:when test="${loggedin == false}">
					<a class="nav-link" href="/sign-up">Sign up</a>
				</c:when>
				<c:when test="${loggedin == true}">
				<a class="nav-link" href="/logout">Sign Out</a>
				</c:when>
			</c:choose>
		</li>
		
	</ul>

	<ul class="nav">

		<li class="nav-item">
			<a class="nav-link" href="/">Find Recipes</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="/favorite">Favorites</a>
		</li>
		

		<li class="nav-item">
			<form action="/search">
			<!-- <label>Search: </label> -->
			<input type="search" name="keyword" placeholder="Search" />
			</form>
		</li>
		
	</ul>


	
	
</nav>

</main>

</body>
</html>