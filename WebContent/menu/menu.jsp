<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light navbar-full fixed-top"
	style="background-color: #FFFFFF; border-bottom: solid 1px; margin-bottom: 30px;">

	<div class="navbar-header">
		<a class="navbar-brand" style="color: black" href="./">D'lala</a>
	</div>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li><a class="nav-link" style="color: black"
				href="./deposerannonce">Déposerune annonce </a></li>
			<li><a class="nav-link" style="color: black" href="./annonces">Liste des annonces</a></li>
			<li><a class="nav-link" style="color: black"
				href="./erreur.html">Demandes</a></li>
			<li><a class="nav-link" style="color: black"
				href="./erreur.html">Mes favoris</a></li>
		</ul>

		<span class="navbar-text nav-link" style="color: black"><a
			href="./${ utilisateur.connexionlink }">${ utilisateur.connexion }</a> </span>
	</div>

</nav>