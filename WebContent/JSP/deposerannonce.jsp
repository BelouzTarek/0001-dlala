<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Déposer une annonce</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {

		$("#immobilier").hide();

		$("#vehicules").hide();

		document.getElementById('supprimerImage1').style.visibility = "hidden";
		document.getElementById('supprimerImage2').style.visibility = "hidden";
		document.getElementById('supprimerImage3').style.visibility = "hidden";

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

	function supprimerImage(idimage, idbutton, idInput) {
		document.getElementById(idbutton).style.visibility = "hidden";
		document.getElementById(idimage).src = 'images/icon.svg';
		document.getElementById(idInput).name = 'vide';
	}

	function ajouterImage(event, idimage, idbutton, idInput) {
		var reader = new FileReader();
		reader.onload = function() {

			var output = document.getElementById(idimage);
			output.src = reader.result;
			document.getElementById(idbutton).style.visibility = "visible";
			document.getElementById(idInput).name = idInput;

		}
		reader.readAsDataURL(event.target.files[0]);
	}

	function ajouterAnnonce() {
		var x = document.getElementsByName("vide").length;
		if (x > 2) {
			if (confirm("Voulez vous déposer votre annoce sans photos")) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	(function() {
		$(document)
				.ready(
						function() {
							$('.switch-input')
									.on(
											'change',
											function() {
												var isChecked = $(this).is(
														':checked');
												var selectedData;
												var $switchLabel = $('.switch-label');

												if (isChecked) {
													selectedData = $switchLabel
															.attr('data-on');
												} else {
													selectedData = $switchLabel
															.attr('data-off');
												}

												document
														.getElementById("afficherTelephone").value = selectedData;

											});

							// Params ($selector, boolean)
							function setSwitchState(el, flag) {
								el.attr('checked', flag);
							}

							// Usage
							setSwitchState($('.switch-input'), true);
						});

	})();
</script>

<style>
<%@
include
 
file
="/CSS/toggle.css"%>
</style>
</head>
<body>

	<c:import url="/menu/menu.jsp" />

	<form method="post" action="deposerannonce" id="annonce"
		enctype="multipart/form-data" style="margin-top: 80px;"
		onsubmit="return ajouterAnnonce(this);">

		<div class="container">
			<h3 style="color: black;">Déposer une annonce</h3>
			<div class="card-header">Votre annonce</div>
			<div class="card-body">

				<!-- Erreur -->
				<c:if test="${fn:length(annonce.erreurs) gt 0}">
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<c:forEach items="${ annonce.erreurs }" var="erreur">
							<div>${ erreur.value }</div>
						</c:forEach>
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				<!-- Erreur -->

				<!-- Catégorie -->
				<div class="form-group" id="categorie">
					<label>Catégorie *</label> <select class="form-control"
						style="width: 50%" id="categorie" name="categorie">
						<c:forEach items="${ listecategorie }" var="categorie">
							<c:choose>
								<c:when test="${categorie.value == annonce.categorie}">
									<option ${ categorie.style } value="${ categorie.value }"
										${ categorie.disable } selected>${ categorie.name }</option>
								</c:when>
								<c:otherwise>
									<option ${ categorie.style } value="${ categorie.value }"
										${ categorie.disable }>${ categorie.name }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<!-- Catégorie -->

				<!-- Type d'annonce -->
				<div>
					<label>Type d'annonce *</label>
					<c:choose>
						<c:when test="${annonce.type == 2}">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="typeannonce"
									id="demande" value="2" checked> <label
									class="form-check-label" for="demande">Demande</label>
							</div>

							<div class="form-check form-check-inline"
								style="margin-left: 10px;">
								<input class="form-check-input" type="radio" name="typeannonce"
									id="offre" value=1> <label class="form-check-label"
									for="offre">Offre</label>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="typeannonce"
									id="demande" value="2"> <label class="form-check-label"
									for="demande">Demande</label>
							</div>
							<div class="form-check form-check-inline"
								style="margin-left: 10px;">
								<input class="form-check-input" type="radio" name="typeannonce"
									id="offre" value=1 checked> <label
									class="form-check-label" for="offre">Offre</label>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- Type d'annonce -->

				<!-- Titre de l'annonce -->
				<div class="form-group" style="width: 50%; margin-top: 5px;)">
					<label for="formGroupExampleInput">Titre de l'annonce *</label> <input
						type="text" class="form-control" id="titreannonce"
						name="titreannonce" data-toggle="collapse"
						data-target="#demoTitre" value="${ annonce.titre }">
				</div>
				<div id="demoTitre" class="collapse"
					style="width: 50%; font-size: 13px; font-style: italic;">
					Votre annonce sera refusée si le titre ne décrit pas précisément le
					produit que vous proposez. Ne pas mentionner "Vente" ou "Achat"
					dans le titre.</div>
				<!-- Titre de l'annonce -->

				<!-- immobilier -->
				<div id="immobilier">
					<div class="form-row">
						<div class="form-group col-md-3">
							<label for="typedebien">Type du bien*</label> <select
								class="form-control" id="typedebien" name="typedebien">
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
						<div class="form-group col-md-3">
							<label for="surface">Surface*</label> <input type="text"
								class="form-control" id="surface" name="surface"
								value="${ annonce.immobilier.surface }">
						</div>
					</div>


					<div class="form-row">
						<div class="form-group col-md-3">
							<label for="pieces">Piéces*</label> <input type="text"
								class="form-control" id="pieces" name="pieces"
								value="${ annonce.immobilier.pieces }">
						</div>
						<div class="form-group col-md-3">
							<label for="meuble">Meublé/Non Meublé*</label> <select
								class="form-control" id="meuble" name="meuble">
								<option value="meuble">Meublé</option>
								<option value="nonmeuble">Non Meublé</option>
							</select>
						</div>
					</div>

				</div>
				<!-- immobilier -->

				<!-- vehicules -->
				<div id="vehicules">
					<div class="form-row">
						<div class="form-group col-md-3">
							<label for="marque">Marque*</label> <select class="form-control"
								id="marque" name="marque">
								<option value="0" selected>Choisissez</option>
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
						<div class="form-group col-md-3">
							<label for="modele">Modéle*</label> <input type="text"
								class="form-control" id="modele" name="modele"
								value="${ annonce.vehicule.modele }">
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-3">
							<label for="carburant">Carburant*</label> <select
								class="form-control" id="carburant" name="carburant">
								<option value="0" selected>Choisissez</option>
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
						<div class="form-group col-md-3">
							<label for="cylindree">Année*</label> <input type="text"
								class="form-control" id="annee" name="annee"
								value="${ annonce.vehicule.annee }">
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-3">
							<label for="boitevitesse">Boite vitesse*</label> <select
								class="form-control" id="boitevitesse" name="boitevitesse">
								<option value="0" selected>Choisissez</option>
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

						<div class="form-group col-md-3">
							<label for="kilometrage">Kilométrage*</label> <input type="text"
								class="form-control" id="kilometrage" name="kilometrage"
								value="${ annonce.vehicule.kilometrage }">
						</div>
					</div>

				</div>
				<!-- vehicules -->

				<!-- Description de l'annonce -->
				<div class="form-group" style="width: 50%">
					<label for="exampleFormControlTextarea1">Description de
						l'annonce</label>
					<textarea class="form-control" id="descriptionannonce"
						name="descriptionannonce" rows="10" maxlength="4000"
						data-toggle="collapse" data-target="#demoDescription">${ annonce.description }</textarea>
				</div>

				<div id="demoDescription" class="collapse"
					style="width: 50%; font-size: 13px; font-style: italic;">
					Indiquez dans le texte de l’annonce si vous proposez un droit de
					rétractation à l’acheteur. En l’absence de toute mention,
					l’acheteur n’en bénéficiera pas et ne pourra pas demander le
					remboursement ou l’échange du bien ou service proposé.</div>
				<!-- Description de l'annonce -->

				<!-- Prix -->
				<div class="form-group" style="width: 50%">
					<label id="prix" for="formGroupExampleInput">Prix *</label> <input
						type="text" class="form-control" id="prix" name="prix"
						data-toggle="collapse" data-target="#demoPrix"
						value="${ annonce.prix }">
				</div>

				<div id="demoPrix" class="collapse"
					style="width: 50%; font-size: 13px; font-style: italic; margin-left: 10px">
					Indiquez le Prix en DA (pas de point, de virgule ou d'espace).</div>
				<!-- Prix -->

				<!-- Photos -->
				<div class="label">
					<span
						style="font-size: 15px; font-style: italic; font-weight: blod;">Photos
						: </span><span style="font-size: 13px; font-style: italic;">Une
						annonce avec photo est plus consultée qu'une annonce sans photo</span>
				</div>
				<div class="card" style="height: auto;">
					<input type="file" accept="image/*"
						onchange="ajouterImage(event,'image1','supprimerImage1','imageInput1')"
						id="imageInput1" name="vide" style="display: none;"> <input
						type="file" accept="image/*"
						onchange="ajouterImage(event,'image2','supprimerImage2','imageInput2')"
						id="imageInput2" name="vide" style="display: none;"> <input
						type="file" accept="image/*"
						onchange="ajouterImage(event,'image3','supprimerImage3','imageInput3')"
						id="imageInput3" name="vide" style="display: none;">
					<div class="card-header" id="header">Ajouter des photos</div>
					<div class="card-body">
						<div class="row">
							<div class="col-lg-4">
								<div>
									<img class="rounded" id="image1" name="image1"
										src="images/icon.svg" height="200px" width="200px"
										onclick="document.getElementById('imageInput1').click();">
								</div>
								<div>
									<input
										onclick="supprimerImage('image1','supprimerImage1','imageInput1');"
										id="supprimerImage1" class="btn btn-danger" value="Supprimer"
										style="margin-top: 10px;">
								</div>
							</div>

							<div class="col-lg-4">
								<div>
									<img class="rounded" id="image2" name="image2"
										src="images/icon.svg" height="200px" width="200px"
										onclick="document.getElementById('imageInput2').click();">
								</div>
								<div>
									<input
										onclick="supprimerImage('image2','supprimerImage2','imageInput2');"
										id="supprimerImage2" class="btn btn-danger" value="Supprimer"
										style="margin-top: 10px;">
								</div>
							</div>

							<div class="col-lg-4">
								<div>
									<img class="rounded" id="image3" name="image3"
										src="images/icon.svg" height="200px" width="200px"
										onclick="document.getElementById('imageInput3').click();">
								</div>
								<div>
									<input
										onclick="supprimerImage('image3','supprimerImage3','imageInput3');"
										id="supprimerImage3" class="btn btn-danger" value="Supprimer"
										style="margin-top: 10px;">
								</div>
							</div>
						</div>
					</div>

					<!-- Photos -->
				</div>

				<!-- Localisation -->
				<div class="card" style="margin-top: 5%; margin-bottom: 5%;">
					<div class="card-header">Localisation</div>
					<div class="card-body">
						<div class="form-group">
							<div class="form-group" style="width: 50%; margin-top: 5px;)">
								<label for="formGroupExampleInput">Adresse *</label> <input
									type="text" class="form-control" id="adresse" name="adresse"
									value="${ annonce.adresse }">
							</div>
							<label>Wilaya *</label> <select class="form-control"
								style="width: 20%" id="wilaya" name="wilaya">
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
				</div>
				<!-- Localisation -->

				<!-- Contacte -->
				<div class="card" style="margin-top: 5%; margin-bottom: 5%;">
					<div class="card-header">Contacte</div>
					<div class="card-body">
						<div class="row">
							<div class="col-lg-3">Telephone :</div>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="telephone"
									name="telephone" value="${ annonce.telephone }">
							</div>
							<div class="col-lg-6">
								<label class="switch"><input class="switch-input"
									type="checkbox" /> <span class="switch-label"
									data-on="Afficher" data-off="Masquer"></span> <span
									class="switch-handle"></span> </label>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-3">Email :</div>
							<div class="col-lg-3">								
								<input type="text" class="form-control" id="email"
										name="email" value="${ annonce.email }">
							</div>
						</div>
						<input id="afficherTelephone" name="afficherTelephone"
							value="Afficher" style="display: none;">
					</div>
				</div>
				<!-- Contacte -->

				<!-- Valider -->
				<div style="margin-bottom: 5%; float: right">
					<button class="btn btn-secondary" id="valider">Valider</button>
				</div>
				<!-- Valider -->
			</div>
		</div>
	</form>

</body>
</html>