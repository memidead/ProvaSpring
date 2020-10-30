package webapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import webapp.domain.Articoli;

public class ArticoliMapper implements RowMapper<Articoli>
{
	public Articoli mapRow(ResultSet row, int rowNum) throws SQLException
	{
		Articoli articoli = new Articoli();
		
		try
		{
			articoli.setCodArt(row.getString("CODART").trim());
			articoli.setDescrizione(row.getString("DESCR").trim());
			articoli.setUm(row.getString("UM"));
			articoli.setCodStat(row.getString("CODSTAT").trim()); 
			articoli.setPzCart(row.getInt("PEZZI"));
			articoli.setPesoNetto(row.getDouble("PESO"));
			articoli.setIdIva(row.getInt("IDIVA"));
			articoli.setIdStatoArt(row.getString("IDSTATOART").trim());
			articoli.setIdFamAss(row.getInt("IDFAMASS"));
			articoli.setDataCreaz(row.getDate("DATACREAZ"));
		 }
		 catch (Exception ex)
		 {
			 System.out.println("Errore in ArticoliMapper.mapRow: " + ex);
		 }
		
 
		return articoli;
	}
}
