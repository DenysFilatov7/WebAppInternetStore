package com.epam.dfilatov.istore.service.impl;

import com.epam.dfilatov.istore.service.OrderService;
import com.epam.dfilatov.istore.service.ProductService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class ServiceManager {
    private static final Logger LOGGER = Logger.getLogger(ServiceManager.class);
    private final ProductService productService;
    private final OrderService orderService;
    private final Properties applicationProperties = new Properties();
    private final BasicDataSource dataSource;

    public static ServiceManager getInstance(ServletContext servletContext) {
        ServiceManager instance = (ServiceManager) servletContext.getAttribute("SERVICE_MANAGER");
        if (instance == null) {
            instance = new ServiceManager(servletContext);
            servletContext.setAttribute("SERVICE_MANAGER", instance);
        }
        return instance;
    }

    public ProductService getProductService() {
        return productService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public String getApplicationProperty(String key) {
        return applicationProperties.getProperty(key);
    }

    public void close() {
        try {
            dataSource.close();
        } catch (SQLException e) {
            LOGGER.error("Close data source failed: " + e.getMessage(), e);
        }
    }

    private ServiceManager(ServletContext context) {
        loadApplicationProperties();
        dataSource = createDataSource();
        productService = new ProductServiceImpl(dataSource);
        orderService = new OrderServiceImpl();
    }

    private BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDefaultAutoCommit(false);
        dataSource.setRollbackOnReturn(true);
        dataSource.setDriverClassName(getApplicationProperty("db.driver"));
        dataSource.setUrl(getApplicationProperty("db.url"));
        dataSource.setUsername(getApplicationProperty("db.username"));
        dataSource.setPassword(getApplicationProperty("db.password"));
        dataSource.setInitialSize(Integer.parseInt(getApplicationProperty("db.pool.initSize")));
        dataSource.setMaxTotal(Integer.parseInt(getApplicationProperty("db.pool.maxSize")));
        return dataSource;
    }

    private void loadApplicationProperties() {
        try (InputStream inputStream = ServiceManager.class.getClassLoader().getResourceAsStream("application.properties")) {
            applicationProperties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
