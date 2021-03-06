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
	<section id="mp">
		<h1>Search for a Recipe</h1>
		
		<!-- Search bar -->
		<form class="search" action="/search">
			<input type="hidden" name="fromNum" value="${ fromNum }">
			<input type="hidden" name="toNum" value="${ toNum }">
			<input type="search" name="keyword" required/>
			
			
			<button class="btn btn-dark" type="submit">Search</button>
		</form>
		<a href="/advanced">Advanced Search</a>
	
	</section>
	</main>

</body>
</html>