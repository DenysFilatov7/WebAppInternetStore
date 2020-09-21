package com.epam.dfilatov.istore.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class which implements base rules of forwarding pages.
 *
 * @author Denys Filatov
 */
public class RoutingUtils {
    private RoutingUtils() {
    }

    /**
     * Forward to jsp page, attribute @currentPage will be
     * set in the page-template.jsp.
     *
     * @param jspPage  set page in page folder to which we want to forward.
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException method forward()
     * @throws IOException      method forward()
     */
    public static void forwardToPage(String jspPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("currentPage", "page/" + jspPage);
        request.getRequestDispatcher("/WEB-INF/jsp/page-template.jsp").forward(request, response);
    }

    /**
     * Send control to fragment.
     *
     * @param jspFragment
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void forwardToFragment(String jspFragment, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/fragment/" + jspFragment).forward(request, response);
    }

    /**
     * @param text     html text which will be send
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException getWriter()
     */
    public static void sendHTMLFragment(String text, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println(text);
        response.getWriter().close();
    }

    public static void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(url);
    }
}
