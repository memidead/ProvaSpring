package webapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import webapp.domain.Articoli;

@Repository
public class ArticoliRepoImpl implements ArticoliRepo
{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Articoli> SelArticoliByFilter(String Filtro) 
	{
		String Sql = "EXEC [dbo].[Sp_SelArticoli] '" + Filtro + "';";
		
		List<Articoli> articoli = jdbcTemplate.query(Sql, new ArticoliMapper());
		
		return articoli;
	}

	@Override
	public List<Articoli> SelArticoliByFilter(String Filtro, String OrderBy, String Tipo) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsArticolo(Articoli articolo) 
	{
		String Sql = "EXEC Sp_InsArticoli '" + 
				 articolo.getCodArt() + "','" + 
				 articolo.getDescrizione().replace("'", "''") + "','" + 
				 articolo.getUm() + "','" +
				 articolo.getCodStat() + "','" +
				 articolo.getPzCart() + "','" + 
				 articolo.getPesoNetto() + "','" + 
				 articolo.getIdIva() + "','" + 
				 articolo.getIdStatoArt() + "','" +
				 articolo.getIdFamAss() + "'";
		 
		jdbcTemplate.update(Sql);
		
	}

	@Override
	public void DelArticolo(String CodArt) 
	{
		String Sql = "DELETE FROM ARTICOLI WHERE CODART = '" + CodArt + "'";
		
		jdbcTemplate.update(Sql);
		
	}

}
