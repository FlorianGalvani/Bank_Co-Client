package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Customer;
import com.nfs.bank_co.entities.DashboardView;
import com.nfs.bank_co.utils.form.FormUtility;
import com.nfs.bank_co.utils.form.PasswordUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ChangePasswordServlet", value = "/dashboard/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();
        String currentPassword = request.getParameter("currentPassword").trim();
        String newPassword = request.getParameter("newPassword").trim();
        String newPasswordConfirmation = request.getParameter("newPasswordConfirmation").trim();

        FormUtility.checkStringValidity(errors, "currentPassword", currentPassword, 8, 255);
        FormUtility.checkStringValidity(errors, "newPassword", newPassword, 8, 255);
        FormUtility.checkStringValidity(errors, "newPasswordConfirmation", newPasswordConfirmation, 8, 255);

        if (newPassword.equals(newPasswordConfirmation)) {
            if (errors.size() == 0) {
                String hash = null;
                List<DashboardView> dashboardViews = (List<DashboardView>) request.getSession().getAttribute("dashboardView");
                Customer customer = DaoFactory.getCustomerDao().findOneById(dashboardViews.get(0).getCustomerId());
                try {
                    if (PasswordUtility.validatePassword(currentPassword, customer.getPassword())) {
                        hash = PasswordUtility.getHash(newPassword);
                        /*
                        passe l'etat de isNewCustomer à faux si il est à vrai
                        */
                        if (customer.getNewCustomer()) {
                            DaoFactory.getCustomerDao().updateIsNewCustomerState(customer);
                        }

                        DaoFactory.getCustomerDao().updatePassword(customer, hash);
                        request.getSession().removeAttribute("errors");
                        response.sendRedirect(request.getContextPath() + "/dashboard/index.jsp");
                    } else {
                        errors.put("account", "Mot de passe actuel incorrect");
                        request.getSession().setAttribute("errors", errors);
                        response.sendRedirect(request.getContextPath() + "/login.jsp");
                    }
                } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            } else {
                request.getSession().setAttribute("errors", errors);
                response.sendRedirect(request.getContextPath() + "/dashboard/newcustomer.jsp");
            }
        } else {
            errors.put("newPassword", "Ces champs doivent etres identiques");
            errors.put("newPasswordConfirmation", "Ces champs doivent etres identiques");
            request.getSession().setAttribute("errors", errors);
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }
}
