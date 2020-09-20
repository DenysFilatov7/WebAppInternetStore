package com.epam.dfilatov.istore.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {

    public static <T> T select(Connection connection, String sql, ResultSetHandler<T> resultSetHandler, Object... parameters) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            populatePreparedStatement(statement, parameters);
            ResultSet resultSet = statement.executeQuery();
            return resultSetHandler.handle(resultSet);
        }
    }

    private static void populatePreparedStatement(PreparedStatement statement, Object[] parameters) throws SQLException {
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }
        }
    }

    private JDBCUtils() {
    }
}
