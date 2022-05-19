package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PasswordResetServlet", urlPatterns = {"/resetpassword"})
public class PasswordResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientNumber = request.getParameter("clientNumber");
        String email = request.getParameter("email");
        boolean isExist = DaoFactory.getCustomerDao().isExist(email,clientNumber);
        if (isExist) {
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/resetpassword.jsp");
        }
    }
}
