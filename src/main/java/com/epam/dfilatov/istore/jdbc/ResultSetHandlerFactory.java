package com.epam.dfilatov.istore.jdbc;

import com.epam.dfilatov.istore.entity.Product;

import java.util.ArrayList;
import java.util.List;

public final class ResultSetHandlerFactory {
    public static final ResultSetHandler<Product> PRODUCT_RESULT_SET_HANDLER = resultSet -> {
        Product product = new Product();
        product.setCategory(resultSet.getString("category"));
        product.setDescription(resultSet.getString("description"));
        product.setId(resultSet.getInt("id"));
        product.setImageLink(resultSet.getString("image_link"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getBigDecimal("price"));
        product.setProducer(resultSet.getString("producer"));
        return product;
    };

    public static <T> ResultSetHandler<T> getSingleResultSetHandler(final ResultSetHandler<T> oneRowResultSetHandler) {
        return resultSet -> {
            if (resultSet.next()) {
                return oneRowResultSetHandler.handle(resultSet);
            } else {
                return null;
            }
        };
    }

    public static <T> ResultSetHandler<List<T>> getListResultSetHandler(final ResultSetHandler<T> oneRowResultSetHandler) {
        return resultSet -> {
            List<T> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(oneRowResultSetHandler.handle(resultSet));
            }
            return list;
        };
    }

    private ResultSetHandlerFactory() {
    }
}
