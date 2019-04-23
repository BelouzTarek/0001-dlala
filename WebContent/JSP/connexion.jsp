<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Connexion</title>
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
</head>
<body>

	<c:import url="/menu/menu.jsp" />
	<div class="container" style="margin-top: 150px;">

		<div class="row">

			<div class="col-lg">
				<div class="card">
					<div class="card-header" id="header">Connexion</div>
					<div class="card-body">
						<form action="connexion" method="post">
							<input type="text" name="action" id="action" value="connexion"
								style="display: none;"> 
								<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreursconnexion.erreurtechnique }</div>
								<input type="email"
								class="form-control" name="emailconnexion" id="emailconnexion"
								placeholder="Email" value="${ utilisateur.emailconnexion }">
							<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreursconnexion.emailconnexion }</div>

							<input type="password" class="form-control"
								name="motdepasseconnexion" id="motdepasseconnexion"
								placeholder="Mot de passe" style="margin-top: 10px;">
							<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreursconnexion.motdepasseconnexion }</div>
							<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreursconnexion.erreurconnexion }</div>
							<div style="margin-top: 5%; float: right">
								<button class="btn btn-secondary" id="connexion">Connexion</button>
							</div>
						</form>
					</div>

				</div>
			</div>

			<!-- Créer compte -->
			<div class="col-lg">
				<div class="card">
					<div class="card-header" id="header">Créer un compte</div>
					<div class="card-body">
						<div style="color: red; font-style: italic; font-size: 15px;">${ utilisateur.erreurs.erreur }</div>
						<form action="connexion" method="post">
							<input type="text" name="action" id="action"
								value="ajouterutilisateur" style="display: none;">
							<div class="row">
								<div class="col-lg">
									<input type="text" class="form-control" name="nom" id="nom"
										placeholder="Nom" value="${ utilisateur.nom }">
									<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreurs.nom }</div>
								</div>


								<div class="col-lg">
									<input type="text" class="form-control" name="prenom"
										id="prenom" placeholder="Prénom"
										value="${ utilisateur.prenom }">
									<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreurs.prenom }</div>
								</div>
							</div>

							<div style="margin-top: 10px;">
								<input type="email" class="form-control" name="email" id="email"
									placeholder="Email" value="${ utilisateur.email }">
								<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreurs.email }</div>
							</div>

							<div class="row" style="margin-top: 10px;">
								<div class="col-lg">
									<input type="text" class="form-control" name="motdepasse"
										id="motdepasse" placeholder="Mot de passe">
									<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreurs.motdepasse }</div>
								</div>
								<div class="col-lg">
									<input type="text" class="form-control" name="confirmation"
										id="confirmation" placeholder="Confirmation">
									<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreurs.confirmation }</div>
								</div>
							</div>

							<div class="row" style="margin-top: 10px;">
								<div class="col-lg-6">
									<input type="text" class="form-control" name="telephone"
										id="telephone" placeholder="Téléphone"
										value="${ utilisateur.telephone }">
									<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreurs.telephone }</div>
								</div>
							</div>

							<div class="row" style="margin-top: 10px;">
								<div class="col-lg-8">
									<textarea class="form-control" id="adresse" name="adresse"
										rows="3" maxlength="80" placeholder="Adresse">${ utilisateur.adresse }</textarea>
									<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreurs.adresse }</div>
								</div>
								<div class="col-lg-4">
									<select class="form-control" id="wilaya" name="wilaya">
										<c:forEach var="wilaya" items="${ listewilayas }">
											<c:choose>
												<c:when test="${wilaya.numeroWilaya == utilisateur.wilaya}">
													<option value="${ wilaya.numeroWilaya }" selected>${ wilaya.nomWilaya }</option>
												</c:when>
												<c:otherwise>
													<option value="${ wilaya.numeroWilaya }">${ wilaya.nomWilaya }</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>
									</select>
									<div style="color: red; font-style: italic; font-size: 12px;">${ utilisateur.erreurs.wilaya }</div>
								</div>
							</div>

							<div style="margin-top: 5%; float: right">
								<button class="btn btn-secondary" id="inscription">Inscription</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>