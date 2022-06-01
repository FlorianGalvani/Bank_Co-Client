package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Customer;
import com.nfs.bank_co.utils.form.FormUtility;
import com.nfs.bank_co.utils.form.PasswordUtility;

import javax.persistence.NoResultException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "SignInServlet", urlPatterns = {"/login"})
public class SignInServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();

        String customerNumber = request.getParameter("customerNumber").trim();
        FormUtility.checkStringValidity(errors, "customerNumber", customerNumber, 24, 26);

        String password = request.getParameter("password").trim();
        if (errors.size() == 0) {
            try {
                Customer customer = DaoFactory.getCustomerDao().getOneByCustomerNumber(customerNumber);
                List dashboardView = DaoFactory.getCustomerDao().getViewsByCustomerNumber(customerNumber);
                if (customer != null) {

                    if (PasswordUtility.validatePassword(password,customer.getPassword())) {
                        request.getSession().setAttribute("dashboardView", dashboardView);
                        request.getSession().setAttribute("isLogedIn", true);
                        response.sendRedirect(request.getContextPath() + "/dashboard/");
                    } else {
                        errors.put("account", "Identifiant ou mot de passe incorrect");
                        request.getSession().setAttribute("errors", errors);
                        response.sendRedirect(request.getContextPath() + "/login.jsp");
                    }
                }
            } catch (NoResultException e) {
                errors.put("account", "Identifiant ou mot de passe incorrect");
                request.getSession().setAttribute("errors", errors);
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            } catch (NoSuchAlgorithmException e) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            } catch (InvalidKeySpecException e) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");

            }
        } else {
            request.getSession().setAttribute("errors", errors);
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
