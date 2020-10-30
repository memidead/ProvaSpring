package webapp.config;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "webapp")
public class WebApplicationContextConfig implements WebMvcConfigurer
{
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		// cerca le pagine nel formato jsp nella cartella view in WEB-INF
		resolver.setPrefix("/WEB-INF/view");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry r)
	{
		TilesViewResolver vR = new TilesViewResolver();
		r.viewResolver(vR);
	}
}
