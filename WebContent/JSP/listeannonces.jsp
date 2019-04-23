<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listes des annonces</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#immobilier").hide();

		$("#vehicules").hide();

		$("#prix").hide();

		$("#categorie").change(function() {
			var str = "";

			$("#immobilier").hide();
			$("#vehicules").hide();

			$("#categorie option:selected").each(function() {
				str = $(this).val();
			});

			if (str >= 400 && str < 500) {
				$("#immobilier").show();
			} else if (str >= 300 && str < 350) {
				$("#vehicules").show();
			}

		}).change();

	});
</script>
</head>
<body>

	<c:import url="/menu/menu.jsp" />
	<div class="container" style="margin-top: 80px;">

		<div class="row">
			<div class="col-lg-1 col-md-1"></div>
			<div class="col-lg-10 col-md-10">
				<form method="post" action="annonces" id="annonces">
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<input type="text" class="form-control" id="titreannonce"
								name="titreannonce" placeholder="Titre d'annonce">
						</div>
						<div class="col-lg-4 col-md-4">
							<select class="form-control" id="categorie" name="categorie">
								<c:forEach items="${ listecategorie }" var="categorie">
									<c:choose>
										<c:when test="${categorie.value == annonce.categorie}">
											<option ${ categorie.style } value="${ categorie.value }"
												selected>${ categorie.name }</option>
										</c:when>
										<c:otherwise>
											<option ${ categorie.style } value="${ categorie.value }">${ categorie.name }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						<div class="col-lg-2 col-md-2">
							<button class="btn btn-secondary" id="recherche">Recherche</button>
						</div>
					</div>
					<div class="row" style="margin-top: 10px;">
						<div class="col-lg-6 col-md-6">
							<label style="margin-right: 20px;">Type d'annonce </label>
							<c:choose>
								<c:when test="${annonce.type == 2}">
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											name="typeannonce" id="demande" value="2" checked> <label
											class="form-check-label" for="demande">Demande</label>
									</div>

									<div class="form-check form-check-inline"
										style="margin-left: 10px;">
										<input class="form-check-input" type="radio"
											name="typeannonce" id="offre" value=1> <label
											class="form-check-label" for="offre">Offre</label>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											name="typeannonce" id="demande" value="2"> <label
											class="form-check-label" for="demande">Demande</label>
									</div>
									<div class="form-check form-check-inline"
										style="margin-left: 10px;">
										<input class="form-check-input" type="radio"
											name="typeannonce" id="offre" value=1 checked> <label
											class="form-check-label" for="offre">Offre</label>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-lg-4 col-md-4">
							<select class="form-control" id="wilaya" name="wilaya">
								<option value="0" selected>-- Wilayas --</option>
								<c:forEach var="wilaya" items="${ listewilayas }">
									<c:choose>
										<c:when test="${wilaya.numeroWilaya == annonce.wilaya}">
											<option value="${ wilaya.numeroWilaya }" selected>${ wilaya.nomWilaya }</option>
										</c:when>
										<c:otherwise>
											<option value="${ wilaya.numeroWilaya }">${ wilaya.nomWilaya }</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</select>
						</div>
					</div>
					<div id="prix">
						<div class="row" style="margin-top: 10px;">
							<div class="col-lg-2 col-md-2">
								<input type="text" class="form-control" id="prixmin"
									name="prixmin" placeholder="Prix min" data-toggle="collapse"
									data-target="#demoPrix">
							</div>

							<div class="col-lg-2 col-md-2">
								<input type="text" class="form-control" id="prixmax"
									name="prixmax" placeholder="Prix max" data-toggle="collapse"
									data-target="#demoPrix">
							</div>
						</div>
						<div id="demoPrix" class="collapse"
							style="width: 50%; font-size: 12px; font-style: italic;">
							Indiquez le Prix en DA (pas de point, de virgule ou d'espace).</div>
					</div>

					<div id="immobilier">
						<div class="row" style="margin-top: 10px;">
							<div class="col-lg-3 col-md-3">
								<select class="form-control" id="typedebien" name="typedebien">
									<option value="${ typedebien.numero }" selected>Type
										de bien</option>
									<c:forEach items="${ listtypedebien }" var="typedebien">
										<c:choose>
											<c:when
												test="${typedebien.numero == annonce.immobilier.typedebien}">
												<option value="${ typedebien.numero }" selected>${ typedebien.nom }</option>
											</c:when>
											<c:otherwise>
												<option value="${ typedebien.numero }">${ typedebien.nom }</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>
								</select>
							</div>

							<div class="col-lg-3 col-md-3">
								<select class="form-control" id="meuble" name="meuble">
									<option selected>Meublé/Non meublé</option>
									<option value="meuble">Meublé</option>
									<option value="nonmeuble">Non Meublé</option>
								</select>
							</div>
						</div>

						<div class="row" style="margin-top: 10px;">
							<div class="col-lg-3 col-md-3">
								<input type="text" class="form-control" id="surfacemin"
									name="surfacemin" placeholder="Surface min">
							</div>

							<div class="col-lg-3 col-md-3">
								<input type="text" class="form-control" id="surfacemax"
									name="surfacemax" placeholder="Surface max">
							</div>

							<div class="col-lg-2 col-md-2">
								<select class="form-control" id="piecesmin" name="piecesmin">
									<option selected>Pieces min</option>
									<c:forEach items="${ listpieces }" var="piece">
										<option value="${ piece.key }">${ piece.value }</option>
									</c:forEach>
								</select>
							</div>

							<div class="col-lg-2 col-md-2">
								<select class="form-control" id="piecesmax" name="piecesmax">
									<option selected>Pieces max</option>
									<c:forEach var="piece" items="${ listpieces }">
										<option value="${ piece.key }">${ piece.value }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>

					<div id="vehicules">

						<div class="row" style="margin-top: 10px;">
							<div class="col-lg-2 col-md-2">
								<select class="form-control" id="marque" name="marque">
									<option selected>Marque</option>
									<c:forEach var="marque" items="${ listmarque }">
										<c:choose>
											<c:when test="${marque.key == annonce.vehicule.marque}">
												<option value="${ marque.key }" selected>${ marque.value }</option>
											</c:when>
											<c:otherwise>
												<option value="${ marque.key }">${ marque.value }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>

							<div class="col-lg-2 col-md-2">
								<input type="text" class="form-control" id="modele"
									name="modele" placeholder="Modéle">
							</div>

							<div class="col-lg-2 col-md-2">
								<select class="form-control" id="carburant" name="carburant">
									<option selected>Carburant</option>
									<c:forEach var="carburant" items="${ listcarburant }">
										<c:choose>
											<c:when test="${carburant.key == annonce.vehicule.carburant}">
												<option value="${ carburant.key }" selected>${ carburant.value }</option>
											</c:when>
											<c:otherwise>
												<option value="${ carburant.key }">${ carburant.value }</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>
								</select>
							</div>

							<div class="col-lg-2 col-md-2">
								<select class="form-control" id="boitevitesse"
									name="boitevitesse">
									<option selected>Boite vitesse</option>
									<c:forEach var="boitevitesse" items="${ listboitevitesse }">
										<c:choose>
											<c:when
												test="${boitevitesse.key == annonce.vehicule.boitevitesse}">
												<option value="${ boitevitesse.key }" selected>${ boitevitesse.value }</option>
											</c:when>
											<c:otherwise>
												<option value="${ boitevitesse.key }">${ boitevitesse.value }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="row" style="margin-top: 10px;">
							<div class="col-lg-2 col-md-2 col-sm-2">
								<select class="form-control" id="anneemin" name="anneemin">
									<option selected>Année min</option>
								</select>
							</div>

							<div class="col-lg-2 col-md-2 col-sm-2">
								<select class="form-control" id="anneemax" name="anneemax">
									<option selected>Année max</option>
								</select>
							</div>

							<div class="col-lg-3 col-md-3 col-sm-3">
								<input type="text" class="form-control" id="kilometragemin"
									name="kilometragemin" placeholder="Kilométrage min">
							</div>

							<div class="col-lg-3 col-md-3 col-sm-3">
								<input type="text" class="form-control" id="kilometragemax"
									name="kilometragemax" placeholder="Kilométrage max">
							</div>
						</div>

					</div>
				</form>
			</div>
		</div>

		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-10 col-md-10 col-sm-10">
				<ul style="list-style-type: none;">
					<c:forEach var="annonce" items="${ listeannonces }">
						<li onclick="location.href='annonce?idannonce=${ annonce.idannonce }';">
							<div class="card" style="width: auto; margin-top: 10px;">
								<div class="row">
									<div class="col-lg-3 col-md-3 col-sm-3">
										<img src="${ annonce.urlImages[0] }" height="180px"
											width="180px">
									</div>

									<div class="col-lg-3 col-md-3 col-sm-3">
										<h4>${ annonce.titre }</h4>
										<p>${ annonce.prix }</p>

										<div style="margin-top: 10px;">
											<p style="margin: 0px;">${ annonce.categorie }</p>
											<p style="margin: 0px;">${ annonce.wilaya }</p>
											<p style="margin: 0px;">${ annonce.datetime }</p>
										</div>

									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>