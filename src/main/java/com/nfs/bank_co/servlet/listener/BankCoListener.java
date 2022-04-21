package com.nfs.bank_co.servlet.listener;
import com.nfs.bank_co.dao.PersistenceManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class BankCoListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public BankCoListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        PersistenceManager.getEmf().close();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
