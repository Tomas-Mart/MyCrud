package com.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        try {
            servletContext.setRequestCharacterEncoding("UTF-8");
            servletContext.setResponseCharacterEncoding("UTF-8");
            super.onStartup(servletContext);

            ServletRegistration registration = servletContext.getServletRegistration(DEFAULT_SERVLET_NAME);
            if (registration != null) {
                registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
                registration.setInitParameter("dispatchOptionsRequest", "true");
            }
        } catch (Exception e) {
            throw new ServletException("Failed to initialize Spring DispatcherServlet", e);
        }
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // Все конфигурации в одном классе
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}