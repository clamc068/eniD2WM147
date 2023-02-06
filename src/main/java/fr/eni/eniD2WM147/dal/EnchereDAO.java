package fr.eni.eniD2WM147.dal;

import java.time.LocalDateTime;

import fr.eni.eniD2WM147.bo.Enchere;
import fr.eni.eniD2WM147.businessException.BusinessException;

public interface EnchereDAO {
	
	
	public Enchere insertBid(LocalDateTime dateEnchere, int montantEnchere) throws BusinessException;
	public Enchere bidArticle() throws BusinessException;

}
