package com.epam.dfilatov.istore.controller;

import com.epam.dfilatov.istore.entity.Product;
import com.epam.dfilatov.istore.service.BusinessService;
import com.epam.dfilatov.istore.service.ServiceManager;
import com.epam.dfilatov.istore.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Controller which takes products from DB.
 */
@WebServlet("/products")
public abstract class AbstractController extends HttpServlet {
    private static final long serialVersionUID = -9089321130840404257L;

    private BusinessService businessService;

    /**
     * give access to business service from servlets.
     *
     * @throws ServletException
     */
    @Override
    public final void init() throws ServletException {
        businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
    }

    /**
     * Get products from DB,
     * set it as attribute
     * and forward to products.jsp page.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = Collections.emptyList();
        req.setAttribute("products", products);
        RoutingUtils.forwardToPage("products.jsp", req, resp);
    }

    public final BusinessService getBusinessService() {
        return businessService;
    }
}
