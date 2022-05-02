package com.nfs.bank_co.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SendMoneyServlet", urlPatterns = {"/dashboard/sendmoney"})
public class SendMoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/dashboard/sendmoney.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Ajouter logique envoi  d'argent
        request.getSession().setAttribute("success","'Transfert effectué'");
        response.sendRedirect(request.getContextPath() + "/dashboard/");
    }
}
