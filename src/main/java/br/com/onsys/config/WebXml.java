package br.com.onsys.config;

import java.util.List;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages={"br.com.onsys.*"})
public class WebXml implements  WebApplicationInitializer,  WebMvcConfigurer {

	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(WebXml.class);

        inicializarParametros(servletContext);
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
                new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(appContext);

        servletContext.addListener(contextLoaderListener);

        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);

        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");
        
     
    }
	
	
	/**
	 * 
	 * @return 
     * 	<context-param>
			<param-name>javax.faces.FACELETS_SKIP_COMMENTS</param-name>
			<param-value>true</param-value>
		</context-param>

		<context-param>
			<description>State saving method: 'client' or 'server' (=default). See JSF Specification 2.5.2</description>		
			<param-name>javax.faces.STATE_SAVING_METHOD</param-name>
			<param-value>client</param-value>
		</context-param>
	 */
	
	protected void inicializarParametros(ServletContext servletContext) {
	    servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");	            
        servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "client");
        
        
        servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE","true");
        
        /* colocar um tema do primefaces
        servletContext.setInitParameter("primefaces.THEME","start");
        */
        servletContext.setInitParameter("primefaces.FONT_AWESOME","true");

	}

	/**
	 * adiciona a configura��o de (Cross-origin resource sharing) habilitando acesso para Requisi�oes REST
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
       
    	registry.addMapping("/**").
        		 allowedOrigins("*").
        		 allowedHeaders("Origin", "X-Requested-With", "Content-Type, Accept").
        		 maxAge(3600).
        		 allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE", "PATCH").
        		 exposedHeaders("Location");
    }
	
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {		
		registry.jsp("/webapp/", ".xhtml");
	}
	
	
	/* caso queira redirecionar diretamente para a pagina inicial */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("forward:/index.xhtml");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	

	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
		
	}


	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {		
	}


	@Override
	public void addFormatters(FormatterRegistry registry) {		
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {		
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {		
	}


	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {		
	}


	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
	}



}
