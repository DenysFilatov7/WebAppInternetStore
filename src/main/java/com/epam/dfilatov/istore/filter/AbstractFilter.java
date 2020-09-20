package com.epam.dfilatov.istore.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class provide template for Internet Store filters.
 *
 * @author Denys Filatov
 */
public abstract class AbstractFilter implements Filter {
    protected final Logger LOGGER = Logger.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Abstract method which will be using by
     * all filters in InternetStore app.
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param filterChain FilterChain
     * @throws IOException
     * @throws ServletException
     */
    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException;

    /**
     * Convert downcast ServletRequest to HttpServletRequest, and
     * ServletResponse to HttpServletResponse.
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException FilterChain.doFilter() could throw;
     * @throws ServletException FilterChain.doFilter() could throw
     */
    @Override
    public final void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
