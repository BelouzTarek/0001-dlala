<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>D'lala</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="/menu/menu.jsp" />
	<h4
		style="font-weight: bold; font-style: italic; margin-left: 10px; margin-top: 80px;">Trouvez
		la bonne affaire parmi les annonces sur D'lala</h4>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 col-sm-2">
				<ul style="vertical-align: top; float: left;">
					<c:forEach var="wilaya1" items="${ listewilayasp1 }">
						<li><a style="color: black"
							href="./annonces?wilaya=${ wilaya1.numeroWilaya }">${ wilaya1.nomWilaya }</a></li>
					</c:forEach>
				</ul>
			</div>

			<div class="col-lg-2 col-sm-2">
				<ul style="vertical-align: top; float: left;">
					<c:forEach var="wilaya2" items="${ listewilayasp2 }">
						<li><a style="color: black"
							href="./annonces?wilaya=${ wilaya2.numeroWilaya }">${ wilaya2.nomWilaya }</a></li>
					</c:forEach>
				</ul>
			</div>

			<div class="col-lg-8 col-sm-8">
				<img
					style="height: auto; width: auto; display: inline-block; margin-top: auto; margin-bottom: auto;"
					src="images/Algeria.svg">
			</div>
		</div>
	</div>
	<p
		style="margin-left: 5%; margin-right: 5%; margin-top: 3%; font-style: italic; font-size: 12px">D'lala
		est le site référent de petites annonces de particulier à particulier
		et professionnels en France. Découvrez nos annonces voitures
		d'occasion, motos, immobilier, emploi, location de vacances,
		vêtements, électroménager, jouets, déco, meubles, etc... Déposez une
		annonce gratuite en toute simplicité pour vendre, donner vos biens ou
		promouvoir vos services. Avec des milliers de nouvelles annonces mises
		en ligne chaque jour vous trouverez l'objet d'occasion ou neuf que
		vous désirez.</p>
</body>
</html>