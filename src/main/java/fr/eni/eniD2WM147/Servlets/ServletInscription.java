package fr.eni.eniD2WM147.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eneDW2M147.businessException.BusinessException;
import fr.eni.eniD2WM147.bll.EnchereManager;
import fr.eni.eniD2WM147.bo.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final String MOTIF = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9-]{2,}[.][a-zA-Z]{2,3}$";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/Inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// une fois connecté redirigé vers l'ecran d'accueil en mode connecté // annuler
		// n'enregistre pas l'utilisateur et envoie directement sur la page // d'accueil
		// HttpSession session = request.getSession();
		EnchereManager em = new EnchereManager();
		Utilisateur u = null;
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("mdp");
		String confirmation = request.getParameter("confirmation");
		
		try {
			BusinessException bE = new BusinessException();
			if (pseudo.isBlank() || !pseudo.chars().allMatch(Character::isLetterOrDigit)) {
				bE.addMessage("Le pseudo ne peut contenir que des chiffres et des lettres");
				throw bE;
			}
			if (nom.isBlank() || !nom.chars().allMatch(Character::isLetter)) {
				bE.addMessage("Le nom est obligatoire et ne peut contenir que des lettres.");
				throw bE;
			}
			if (prenom.isBlank() || !prenom.chars().allMatch(Character::isLetter)) {
				bE.addMessage("Le prenom est obligatoire et ne peut contenir que des lettres.");
				throw bE;
			}
			if (email.isBlank() || !email.contains(MOTIF)) {
				bE.addMessage("Adresse mail non valide.");
				throw bE;
			}
			// mettre limitation en chiffre et 10
			if (tel.isBlank() || !tel.chars().allMatch(Character::isDigit)) {
				bE.addMessage("Le numéro de téléphone doit contenir 10 chiffres.");
				throw bE;
			}

			if (rue.isBlank()) {
				bE.addMessage("La rue est obligatoire.");
				throw bE;
			}
			if (codePostal.isBlank()) {
				bE.addMessage("Le code postal est obligatoire.");
				throw bE;
			}
			if (ville.isBlank()) {
				bE.addMessage("La ville est obligatoire.");
				throw bE;
			}
			if (mdp.isBlank()) {
				bE.addMessage("Le mot de passe est obligatoire.");
				throw bE;
			}
			if (confirmation.isBlank() & confirmation.equals(mdp)) {
				bE.addMessage("Veuillez confirmer votre mot de passe");
				throw bE;
			}
			if (!bE.getListeMessage().isEmpty()) {
				throw bE;
			}
			em.insertUtilisateur(pseudo, nom, prenom, email, tel, rue, codePostal, ville, 100, false);
			response.sendRedirect(request.getContextPath() + "/accueil");
		} catch (

		BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeErreur", e.getListeMessage());
			doGet(request, response);
		}
	}

}