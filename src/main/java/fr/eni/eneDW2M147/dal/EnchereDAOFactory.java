package fr.eni.eneDW2M147.dal;

public class EnchereDAOFactory {

	public static EnchereDAO getEnchereDao() {

		return new EnchereDaoJdbcImpl();

	}
}