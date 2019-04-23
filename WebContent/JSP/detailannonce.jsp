<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>${ annonce.titre }</title>


</head>
<body>

	<c:import url="/menu/menu.jsp" />

	<div class="container" style="margin-top: 100px;">
		<div id="carousel-example-2" class="carousel slide carousel-fade"
			data-ride="carousel" style="height: 50%;width: 50%">
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-2" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-2" data-slide-to="1"></li>
				<li data-target="#carousel-example-2" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="carousel-item active">
					<div class="view">
						<img class="d-block w-100"
							src="images/icon.svg"
							alt="First slide">
						<div class="mask rgba-black-light"></div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="view">
						<img class="d-block w-100"
							src="images/icon.svg"
							alt="Second slide">
						<div class="mask rgba-black-strong"></div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="view">
						<img class="d-block w-100"
							src="images/icon.svg"
							alt="Third slide">
						<div class="mask rgba-black-slight"></div>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carousel-example-2"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carousel-example-2"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>


</body>
</html>



