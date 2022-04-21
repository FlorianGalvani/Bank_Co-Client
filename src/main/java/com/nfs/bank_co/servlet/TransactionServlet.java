package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.CustomerAccounts;
import com.nfs.bank_co.entities.Transaction;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "TransactionServlet", urlPatterns = {"/test"})
public class TransactionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      Transaction transaction = new Transaction(new Date(), new CustomerAccounts("azerty123", "main", 1200,200), new CustomerAccounts("ytreza321", "main", 600,200), 10000000, "Heritage de la vieille");
        System.out.println("JE POSTE");
        DaoFactory.getTransactionDao().create(transaction);
        response.sendRedirect(request.getContextPath());


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
