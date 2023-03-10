package fr.eni.eniD2WM147.bo;

import java.util.List;

public class Categorie {
	private int numCategorie;
	private String libelle;
	List<ArticleVendu> articles;

	public Categorie(int numCategorie, String libelle) {
		super();
		this.numCategorie = numCategorie;
		this.libelle = libelle;
	}

	public Categorie(int numCategorie) {
		super();
		this.numCategorie = numCategorie;
	}

	public Categorie(int numCategorie, String libelle, List<ArticleVendu> articles) {
		super();
		this.numCategorie = numCategorie;
		this.libelle = libelle;
		this.articles = articles;
	}

	public Categorie() {
	
	}

	public int getNumCategorie() {
		return numCategorie;
	}

	public void setNumCategorie(int numCategorie) {
		this.numCategorie = numCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ArticleVendu> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleVendu> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Categorie [numCategorie=" + numCategorie + ", libelle=" + libelle + ", articles=" + articles + "]";
	}
	
	

}
