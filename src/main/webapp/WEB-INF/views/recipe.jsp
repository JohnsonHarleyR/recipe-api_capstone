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
<main class="container">

<!-- Recipe name goes here (ex.) ${recipe.name} -->
${ recipe.uri }

${ recipe.label }

${ recipe.image }

${ recipe.source }

${ recipe.url }

${ recipe.shareAs }

${ recipe.yeild }

<c:forEach items="${ recipe.dietLabels }" var="dietLabel">
	${ dietLabel }
</c:forEach>

<c:forEach items="${ recipe.cautions }" var="caution">
	${ caution }
</c:forEach>

<c:forEach items="${ recipe.ingredients }" var="ingredient">
	${ ingredient.text }
	${ ingredient.weight }
</c:forEach>

${ recipe.calories }

${ recipe.totalWeight }

${ recipe.totalTime }




</main>

</body>
</html>