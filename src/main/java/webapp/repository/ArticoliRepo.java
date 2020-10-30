package webapp.repository;

import java.util.List;

import webapp.domain.Articoli;

public interface ArticoliRepo 
{
	List <Articoli> SelArticoliByFilter(String Filtro);
	
	List <Articoli> SelArticoliByFilter(String Filtro, String OrderBy, String Tipo);
		
	void InsArticolo(Articoli articolo);
	
	void DelArticolo(String CodArt);
}
