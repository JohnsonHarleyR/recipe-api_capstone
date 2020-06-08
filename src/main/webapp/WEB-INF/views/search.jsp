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

					<h1>Search Results</h1>



				</article>
				<article class="card-body" id="results">
					<ul>
						<c:forEach var="hit" items="${searchResult.hits}">


							<li>
								<table>
									<tr>
										<td>
											<img id="imagethumb" href="/recipe?recipe=${ hit.recipe.label }" src="${ hit.recipe.image }" >
										</td>
										<td>
											<h4><a href="/recipe?recipe=${ hit.recipe.label }">${hit.recipe.label}</a></h4>
											<ul>
												<c:forEach items="${ hit.recipe.dietLabels }" var="dietLabel">
													<li>
														${ dietLabel }
													</li>
												</c:forEach>
											</ul>
										</td>
									</tr>
								</table>
							</li>






						</c:forEach>
					</ul>
				</article>

				<!-- Do this a different way, it is adding numbers up when it shouldn't -->
				<section id="pages">
					<a href="/previous">prev</a> - ${page} - <a href="/next">next</a> <br>
					<br>
				</section>



			</article>

		</div>
	</main>

</body>
</html>