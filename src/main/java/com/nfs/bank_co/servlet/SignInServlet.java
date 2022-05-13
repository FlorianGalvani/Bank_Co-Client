package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.DashboardView;
import com.nfs.bank_co.utils.FormUtility;

import javax.persistence.NoResultException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "SignInServlet", urlPatterns = {"/login"})
public class SignInServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();

        String customerNumber = request.getParameter("customerNumber").trim();
        FormUtility.checkStringValidity(errors, "customerNumber", customerNumber, 24, 26);

        // TODO Ajouter verification mot de passe
        String password = request.getParameter("password").trim();

        if (errors.size() == 0) {
            try {
//               Customer customer = DaoFactory.getCustomerDao().getOneByCustomerNumber(customerNumber);
                List dashboardView = DaoFactory.getCustomerDao().getViewsByCustomerNumber(customerNumber);

                request.getSession().setAttribute("dashboardView", dashboardView);
                request.getSession().setAttribute("isLogedIn", true);
                response.sendRedirect(request.getContextPath() + "/dashboard/");
            } catch (NoResultException e) {

                errors.put("account", "Identifiant ou mot de passe incorrect");
                request.getSession().setAttribute("errors", errors);
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        } else {
            request.getSession().setAttribute("errors", errors);
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
