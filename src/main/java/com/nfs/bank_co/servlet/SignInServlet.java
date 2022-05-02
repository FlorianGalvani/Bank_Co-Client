package com.nfs.bank_co.servlet;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.google.gson.Gson;
import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Customer;
import com.nfs.bank_co.entities.NewCustomerRequest;
import com.nfs.bank_co.utils.AuthenticationUtility;
import com.nfs.bank_co.utils.FormToolBox;

import javax.persistence.NoResultException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@WebServlet(name = "SignInServlet", urlPatterns = {"/login"})
public class SignInServlet extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();

        String customerNumber = request.getParameter("customerNumber").trim();
        FormToolBox.checkStringValidity(errors, "customerNumber", customerNumber, 24, 26);
        // TODO Ajouter verification mot de passe

        String password = request.getParameter("password").trim();

        if (errors.size() == 0) {
            try {

                Customer customer = DaoFactory.getCustomerDao().getOneByCustomerNumber(customerNumber);
                String token = AuthenticationUtility.createToken();
                if (token != null) {
                    Cookie tokenCookie = new Cookie("token", token);
                    tokenCookie.setMaxAge(3600 * 3);
                    response.addCookie(tokenCookie);
                    request.getSession().setAttribute("customer",customer);
                    response.sendRedirect(request.getContextPath() + "/dashboard/");
                }
            } catch (NoResultException e) {

                errors.put("account","Identifiant ou mot de passe incorrect");
                request.getSession().setAttribute("errors", errors);
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        } else {
            request.getSession().setAttribute("errors", errors);
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
