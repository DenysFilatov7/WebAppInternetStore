package com.epam.dfilatov.istore.listener;

import com.epam.dfilatov.istore.service.ServiceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Class listener which give access to
 * the service manager before app is started.
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    private ServiceManager serviceManager;

    /**
     * Initialize service manager.
     *
     * @param sce notifications about changes to the servlet context of a web application.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        serviceManager = ServiceManager.getInstance(sce.getServletContext());
    }

    /**
     * close service manager.
     *
     * @param sce notifications about changes to the servlet context of a web application
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        serviceManager.close();
    }
}
