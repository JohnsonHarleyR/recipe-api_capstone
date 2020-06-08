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
<title>Recipe</title>
</head>
<body>

<!-- Header -->
<section class="header">
<%@ include file="partials/header.jsp" %>
</section>

<!-- MainBody -->
<main class="container" id="searchresult">
	<h1>
		${ recipe.label }
	</h1>
	
	<div>
		<img src="${ recipe.image }"/>
	</div>
	
		<div>
		<h3>Ingredients:</h3>
		<ul>
			<c:forEach items="${ recipe.ingredients }" var="ingredient">
				<li>
					${ ingredient.text }
				</li>
			</c:forEach>
		</ul>
	</div>	
	
	<div>
		<h3>Servings: ${ recipe.yield }</h3>
	</div>
	
	<div>
		<h2>
			<a href="${ recipe.url }" class="btn btn-dark">Full Recipe from ${ recipe.source }</a>
		</h2>
	</div>
	
	<div>
		<form action="/favorite/add" method="post">
		<h2>
			
			<input type="hidden" name="name" value="${recipe.label}"/>
			<input type="hidden" name="url" value="${recipe.url}"/>
			<input type="hidden" name="imageurl" value="${recipe.image}"/>
			
			<button  type="submit" url="/favorite/add" class="btn btn-light">Save Favorite!</button>
			
		</h2>
		</form>
	</div>
	
	
	
	<div>
		<h3>Dietary Information:</h3>
		<ul>
			<c:forEach items="${ recipe.dietLabels }" var="dietLabel">
				<li>
					${ dietLabel }
				</li>
			</c:forEach>
		</ul>	
	</div>
	
	<div>
		<h3>Cautions:</h3>
		<ul>
			<c:forEach items="${ recipe.cautions }" var="caution">
				<li>
					${ caution }
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<h3>Calories per serving: 
	<fmt:formatNumber type="number" maxFractionDigits="0" value="${ recipe.calories/recipe.yield }" />
	</h3>

	<h3>Total cooking time: 
	<fmt:formatNumber type="number" maxFractionDigits="0" value="${ recipe.totalTime }" />
	 minutes</h3>
	 
	 <h3>Nutrition Information:</h3>

	<ul>
		<c:forEach items="${ recipe.digest }" var="dig">
			<li>
				${ dig.label } - 
				<fmt:formatNumber type="number" maxFractionDigits="0" value="${ dig.total }" />
				${ dig.unit } 
			</li>
			<ul>
				<c:forEach items="${ dig.sub }" var="s">
					<li>
						${ s.label } -  
						<fmt:formatNumber type="number" maxFractionDigits="0" value="${ s.total }" />
						${ s.unit }	
					</li>
				</c:forEach>
			</ul>	
		</c:forEach>
	</ul>

</main>

</body>
</html>