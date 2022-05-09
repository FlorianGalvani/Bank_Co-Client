package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", value = "/dashboard/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO ajouter logique modification mot de passe
        System.out.println("POSTTTT");
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        if (customer.getNewCustomer()) {
//            DaoFactory.getCustomerDao().updateNewCustomerState(customer);
        }
        response.sendRedirect(request.getContextPath() + "/dashboard/index.jsp");
    }
}
