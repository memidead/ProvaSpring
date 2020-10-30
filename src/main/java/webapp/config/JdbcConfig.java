package webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"webapp.config"})
@PropertySource(value = {"classpath:application.properties"})
public class JdbcConfig 
{
	@Autowired
	private Environment env;
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dS)
	{
		return new JdbcTemplate(dS);
	}
	
	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dS)
	{
		return new NamedParameterJdbcTemplate(dS);
	}
	
	@Bean(name="dS")
	public DataSource dataSource()
	{
		DriverManagerDataSource dS = new DriverManagerDataSource();
		dS.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		dS.setUrl(env.getRequiredProperty("jdbc.url"));
		dS.setUsername(env.getRequiredProperty("jdbc.username"));
		dS.setPassword(env.getRequiredProperty("jdbc.password"));
		return dS;
	}
	
	@Bean
	public DataSourceTransactionManager tM()
	{
		DataSourceTransactionManager tM = new DataSourceTransactionManager();
		tM.setDataSource(dataSource());
		return tM;
	}
}
