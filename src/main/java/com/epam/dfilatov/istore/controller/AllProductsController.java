package com.epam.dfilatov.istore.controller;

import com.epam.dfilatov.istore.entity.Product;
import com.epam.dfilatov.istore.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Controller which gets products from database
 * and send products web page.
 *
 * @author Denys Filatov
 */
@WebServlet("/products")
public class AllProductsController extends AbstractController {

    private static final long serialVersionUID = -2501849239506897128L;

    /**
     * Get products list using businessService
     * and put it as request attribute.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = getBusinessService().getProducts();
        req.setAttribute("products", products);
        RoutingUtils.forwardToPage("products.jsp", req, resp);
    }
}
