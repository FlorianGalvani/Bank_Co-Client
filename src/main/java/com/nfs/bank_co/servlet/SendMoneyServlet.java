package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Customer;
import com.nfs.bank_co.entities.Account;
import com.nfs.bank_co.entities.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "SendMoneyServlet", urlPatterns = {"/dashboard/sendmoney"})
public class SendMoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/dashboard/sendmoney.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String debitedAccountId = request.getParameter("debitedAccountId");
        String creditedAccountId = request.getParameter("creditedAccountId");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String reason = request.getParameter("reason");

        System.out.println(debitedAccountId + " -> " + creditedAccountId);

        if (!debitedAccountId.isEmpty() && !creditedAccountId.isEmpty()) {
            if (!debitedAccountId.equals(creditedAccountId)) {
                Customer customer = (Customer) request.getSession().getAttribute("customer");
                Account debitedAccount = customer.getAccountById(Integer.parseInt(debitedAccountId));
                Account creditedAccount = customer.getAccountById(Integer.parseInt(creditedAccountId));
                if (debitedAccount.getBalance() > debitedAccount.getAuthorizedDebt() && (debitedAccount.getBalance() - amount) > debitedAccount.getAuthorizedDebt()) {
                    //TODO Terminer logique envoi  d'argent (verifier si le compte debiteur est en capacité d"etre debité du montant indiqué par l'utilisateur)
                    response.sendRedirect(request.getContextPath() + "/dashboard/");
                    Transaction transaction = new Transaction();
                    transaction.setFromAccount(debitedAccount);
                    transaction.setToAccount(creditedAccount);
                    transaction.setAmount(amount);
                    transaction.setReason(reason);
                    transaction.setDate(new Date(System.currentTimeMillis()));
                    try {
                        //Mise a jour du solde du compte debiteur -
                        DaoFactory.getAccountDao().updateBalance(debitedAccount,-amount);
                        //Mise a jour du solde du compte crediteur +
                        DaoFactory.getAccountDao().updateBalance(creditedAccount, amount);

                        DaoFactory.getTransactionDao().create(transaction);
                        request.getSession().setAttribute("success", "'Transfert effectué'");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    request.getSession().setAttribute("error", "Fond insufisants");
                    response.sendRedirect(request.getContextPath() + "/dashboard/sendmoney.jsp");
                }
            } else {
                request.getSession().setAttribute("error", "Vous ne pouvez pas credité le compte debiteur");
                response.sendRedirect(request.getContextPath() + "/dashboard/sendmoney.jsp");
            }
        } else {
            request.getSession().setAttribute("error", "Veuillez selectioner le compte debiteur et le compte crediteur");
            response.sendRedirect(request.getContextPath() + "/dashboard/sendmoney.jsp");
        }
    }
}
