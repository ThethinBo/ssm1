package com.gzeic.config;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import sun.rmi.server.Dispatcher;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //乱码过滤
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        FilterRegistration.Dynamic encoding = servletContext.addFilter( "encodingFilter", filter );
        encoding.setInitParameter( "encoding", "utf-8" );
        encoding.setInitParameter( "forceEncoding", "true" );


        encoding.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false, "/*" );
        super.onStartup( servletContext );
    }
}
