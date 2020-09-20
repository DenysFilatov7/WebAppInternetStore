package com.epam.dfilatov.istore.service.impl;

import com.epam.dfilatov.istore.entity.Product;
import com.epam.dfilatov.istore.exception.InternalServerException;
import com.epam.dfilatov.istore.jdbc.JDBCUtils;
import com.epam.dfilatov.istore.jdbc.ResultSetHandler;
import com.epam.dfilatov.istore.jdbc.ResultSetHandlerFactory;
import com.epam.dfilatov.istore.service.ProductService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class ProductServiceImpl implements ProductService {

    private final DataSource dataSource;

    private static final ResultSetHandler<List<Product>> productsResultSetHandler =
            ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);

    public ProductServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> listAllProducts(int page, int limit) {
        try (Connection connection = dataSource.getConnection()) {
            int offset = (page - 1) * limit;
            return JDBCUtils.select(connection, "select p.*, c.name as category, pr.name as producer from product p, producer pr, category c "
                    + "where c.id=p.id_category and pr.id=p.id_producer limit ? offset ?", productsResultSetHandler, limit, offset);
        } catch (SQLException e) {
            throw new InternalServerException("Can't execute SQL query" + e.getMessage(), e);
        }
    }
}
