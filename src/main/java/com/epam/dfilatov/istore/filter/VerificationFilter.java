package com.epam.dfilatov.istore.filter;

import com.epam.dfilatov.istore.service.BusinessService;
import com.epam.dfilatov.istore.service.ServiceManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Give access to businessService from filter.
 *
 * @author Denys Filatov
 */
@WebFilter("/")
public class VerificationFilter implements Filter {
    private BusinessService businessService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        businessService = ServiceManager.getInstance(filterConfig.getServletContext()).getBusinessService();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
