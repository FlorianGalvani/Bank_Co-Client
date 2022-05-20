package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Account;
import com.nfs.bank_co.entities.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "AccountServlet", urlPatterns = "/dashboard/account")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            Account account = DaoFactory.getAccountDao().getOneById(Integer.parseInt(id));
            if (account != null) {


                List<Transaction> debts = new ArrayList<>(account.getDebts());
                debts.sort(Comparator.comparing(Transaction::getDate));
                Collections.reverse(debts);
                request.getSession().setAttribute("debts", debts);

                List<Transaction> credits = new ArrayList<>(account.getCredits());
                credits.sort(Comparator.comparing(Transaction::getDate));
                Collections.reverse(credits);
                request.getSession().setAttribute("credits", credits);

                List<Transaction> transactions = new ArrayList<>(account.getDebts());
                transactions.addAll(account.getCredits());
                transactions.sort(Comparator.comparing(Transaction::getDate));
                Collections.reverse(transactions);
                request.getSession().setAttribute("transactions",transactions);

                request.getSession().setAttribute("account", account);

                response.sendRedirect(request.getContextPath() + "/dashboard/account.jsp");
            } else {

                response.sendRedirect(request.getContextPath() + "/dashboard/");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/dashboard/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
