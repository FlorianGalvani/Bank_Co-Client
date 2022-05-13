package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Customer;
import com.nfs.bank_co.utils.PasswordUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

@WebServlet(name = "ChangePasswordServlet", value = "/dashboard/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ajouter logique modification mot de passe
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String newPasswordConfirmation = request.getParameter("newPasswordConfirmation");


        String hash = null;
        try {
            hash = PasswordUtility.getHash(newPassword);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MD5 Hash = " + hash);
        DaoFactory.getCustomerDao().updatePassword(customer,hash);
        
        /*
            passe l'etat de isNewCustomer à faux si il est à vrai
        */ 
        if (customer.getNewCustomer()) {
           DaoFactory.getCustomerDao().updateIsNewCustomerState(customer);
        }
        response.sendRedirect(request.getContextPath() + "/dashboard/index.jsp");
    }
}
