package fr.eni.eniD2WM147.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.eniD2WM147.bll.UtilisateurManager;
import fr.eni.eniD2WM147.bo.Utilisateur;
import fr.eni.eniD2WM147.businessException.BusinessException;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/Login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String mdp = request.getParameter("mdp");

		Utilisateur u = null;

		try {

			BusinessException beLog = new BusinessException();
			if (id.isBlank()) {
				beLog.addMessage("Un Identifiant est obligatoire");
			}
			if (mdp.isBlank()) {
				beLog.addMessage("Un mot de passe est obligatoire");
			}

			if (!beLog.getListeMessage().isEmpty()) {
				throw beLog;
			}
			u = UtilisateurManager.getInstance().getUserByEmailAndPassword(id, mdp);
			if (u == null) {

				System.out.println("LOGIN - FAIL");
				beLog.addMessage("email ou mot de passe incorrect. Veuillez réessayer.");
				throw beLog;

			} else {
				System.out.println(u.getNom() + " " + u.getPrenom());
				System.out.println("LOGIN - SUCCESS");

				session.setAttribute("Utilisateur", u);
				response.sendRedirect(request.getContextPath() + "/accueil");
			}

		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeErreur", e.getListeMessage());
			doGet(request, response);
			System.out.println(e.getMessage());
		}
	}

}
