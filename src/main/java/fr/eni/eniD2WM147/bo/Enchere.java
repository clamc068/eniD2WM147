package fr.eni.eniD2WM147.bo;

import java.time.LocalDateTime;

public class Enchere {
	private LocalDateTime dateEnchere;
	private int montantEnchere;
	Utilisateur utilisateur;
	ArticleVendu article;


	public Enchere(LocalDateTime dateEnchere, int montantEnchere) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Enchere(int montantEnchere, Utilisateur utilisateur) {
		
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
	}

	public Enchere() {

	}



	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", utilisateur="
				+ utilisateur + ", article=" + article + "]";
	}

}
