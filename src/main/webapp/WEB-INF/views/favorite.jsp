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
<title>Search Result</title>
</head>
<body>

	<!-- Header -->
	<section class="header">
		<%@ include file="partials/header.jsp"%>
	</section>

	<!-- MainBody -->
	<main class="container">
		<div id="center">

			<article class="card" style="width: 45rem;">

				<article class="card-header">

					<h1>Favorites</h1>



				</article>
				<article class="card-body" id="results">

					<c:choose>
						<c:when test="${listsize > 0}">


							<ul>
								<c:forEach var="favorite" items="${favorites}">


									<li>
										<p>
										<table>
											<td><a href="${favorite.url}">${favorite.label}</a></td>
											<td><a class="btn-sm btn-danger"
												href="/favorite/delete?id=${ favorite.id }">Delete!</a>
											</td>
										</table>
										</p>
									</li>


									<!-- Do this a different way, it is adding numbers up when it shouldn't -->


									</section>



								</c:forEach>
							</ul>

						</c:when>
						<c:otherwise>
	
	There are no favorites to display.
	
</c:otherwise>
					</c:choose>
				</article>





			</article>



		</div>
	</main>

</body>
</html>