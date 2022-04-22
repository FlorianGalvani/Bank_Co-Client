package com.nfs.bank_co.servlet;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Customer;
import com.nfs.bank_co.entities.NewCustomerRequest;
import com.nfs.bank_co.utils.FormToolBox;

import javax.persistence.NoResultException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "SignInServlet", urlPatterns = {"/login"})
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getMethod());
        if (request.getMethod().equals("GET")) {
            request.getSession().setAttribute("errors", null);
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();

        String customerNumber = request.getParameter("customerNumber").trim();
        FormToolBox.checkStringValidity(errors, "customerNumber", customerNumber, 24, 26);

        String password = request.getParameter("password").trim();
        FormToolBox.checkStringValidity(errors, "password", password, 3, 20);

        if (errors.size() == 0) {
            try {
                Customer customer = DaoFactory.getCustomerDao().getOneByCustomerNumber(customerNumber);
                // TODO Ajouter verification mot de passe
                try {
                    Algorithm algorithm = Algorithm.HMAC256("secret"); // TODO Modifier le secret
                    String token = JWT.create()
                            .withIssuer("auth0")
                            .sign(algorithm);

                    Cookie tokenCookie = new Cookie("token", token);
                    tokenCookie.setMaxAge(3600 * 3);
                    response.addCookie(tokenCookie);
                    Cookie customerIDcookie = new Cookie("id", "1");
                    response.addCookie(customerIDcookie);
                    response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
                } catch (JWTCreationException e) {
                    System.out.println(e);
                }
            } catch (NoResultException e) {
                System.out.println(e);
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
