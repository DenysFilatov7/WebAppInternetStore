package com.epam.dfilatov.istore.service;

import javax.servlet.ServletContext;

/**
 * Service which hold development environment.
 * Should be single instance, which will be store
 * as attribute.
 * Should be accessible for application listener,
 * session listener, servlets, filters, jsp pages.
 */
public class ServiceManager {
    private ServiceManager(ServletContext context) {
        //init resources
    }

    public static ServiceManager getInstance(ServletContext context) {
        ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
        if (instance == null) {
            instance = new ServiceManager(context);
            context.setAttribute("SERVICE_MANAGER", instance);
        }
        return instance;
    }

    private BusinessService businessService;

    public BusinessService getBusinessService() {
        return businessService;
    }

    public void close() {//close resources
    }
}
