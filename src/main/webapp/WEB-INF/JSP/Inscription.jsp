<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>enchère</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="CSS/Style.css" rel="stylesheet">
<body>

	<div id="logErrorMessages">
		<c:if test="${!empty listeErreur }">
			<c:forEach var="erreur" items="${listeErreur }">
				<div id="loginError" class="alert alert-danger" role="alert">
					${listeErreur }</div>
			</c:forEach>
		</c:if>

	</div>
	<header>
		<%@ include file="Entete.html"%>
		<div class="d-flex flex-row-reverse">
			<div class="p-2">
				<a id="topMenu" href="${pageContext.request.contextPath}/login"> Se
					Connecter</a>
			</div>
		</div>
	</header>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li id="bread" class="breadcrumb-item"><a
				href="${pageContext.request.contextPath}/accueil">Home</a></li>
			<li class="breadcrumb-item active" aria-current="page">Inscription</li>
		</ol>
	</nav>
	<div class="container">
		<div class="row justify-content-md-center">
			<h2>Inscription</h2>
		</div>
		<div class="row justify-content-md-center">
			<form action="${pageContext.request.contextPath}/inscription"
				method="post">
				<label id="signUpPseudoLabel" style="font-weight: bold">Pseudo : </label> <input
					id="signUpPseudo" placeholder="Invite01" name="pseudo"
					value="${pseudo}"> <br> <label id="signUpNomLabel" style="font-weight: bold">Nom
					: </label> <input id="signUpNom" type="text" name="nom"
					placeholder="Martin" value="${nom}"> <br> <label
					id="signUpPrenomLabel" style="font-weight: bold">Prenom : </label> <input id="signUpPrenom"
					type="text" name="prenom" placeholder="Camille" value="${prenom}">
				<br> <label id="signUpEmailLabel" style="font-weight: bold">Email : </label> <input
					id="signUpEmail" type="email" name="email"
					placeholder="martincamille@fakemail.com" value="${email}">
				<br> <label id="signUpTelephoneLabel" style="font-weight: bold">Telephone : </label> <input
					id="signUpTelephone" type="tel" name="tel"
					placeholder="01 02 03 04 05" value="${tel}"> <br> <label
					id="signUpRueLabel" style="font-weight: bold">Rue : </label> <input id="signUpRue"
					type="text" name="rue" placeholder="rue de bidule" value="${rue}">
				<br> <label id="signUpCodePostalLabel" style="font-weight: bold">Code Postal : </label> <input
					id="signUpCodePostal" type="text" name="codePostal"
					placeholder="11111" value="${codePostal}"> <br> <label
					id="signUpVilleLabel" style="font-weight: bold">Ville : </label> <input id="signUpVille"
					type="text" name="ville" placeholder="Fausseville" value="${ville}">
				<br>
				<h6 class="mdpCom">
					Le mot de passe doit avoir au moins 8 caractères (max15),<br>
					un chiffre, une lettre majuscule et une minuscule
				</h6>
				<label id="signUpMdpLabel" style="font-weight: bold">Mot de passe : </label> <input
					id="signUpMdp" type="password" name="mdp" placeholder="********"
					required
					pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[-+!*$@%_])([-+!*$@%_\w]{8,15})$">
				<br> <label id="signUpConfirmationLabel" style="font-weight: bold">Confirmation :
				</label> <input id="signUpConfirmation" type="password" name="confirmation"
					placeholder="********"> <br>
				<div class="inscriptionButtons">
					<input id="inscriptionButton" class="btn btn-primary"
						id="signUpOKButton" type="submit" value="Valider"> <a
						id="inscriptionButton" class="btn btn-secondary"
						href="${pageContext.request.contextPath}/accueil">Annuler</a>
				</div>
			</form>
		</div>



	</div>
	<footer id="footer">
		<%@ include file="footer.html"%>
	</footer>
</body>

</html>