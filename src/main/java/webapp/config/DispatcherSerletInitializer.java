package webapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherSerletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected String[] getServletMappings() 
	{
		return new String[] {"/"};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return new Class[]
		{
				WebApplicationContextConfig.class
		};
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
