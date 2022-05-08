package com.nfs.bank_co.servlet.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Customer;
import com.nfs.bank_co.utils.AuthenticationUtility;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/dashboard/index.jsp", "/dashboard/*"})
public class AuthorizationFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String report = "--- AuthorizationFilter ---\n";
//        System.out.println("--- AuthorizationFilter ---");
//        System.out.print("status : ");
        report += "status : ";
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        if(session != null) {
            if (session.getAttribute("customer") != null) {
//                System.out.print("Ok");
                report += "Ok\n" ;
                // MISE A JOUR DU CLIENT si il est connecté
                Customer customer = (Customer) session.getAttribute("customer");
                req.getSession().setAttribute("customer", DaoFactory.getCustomerDao().getOneById(customer.getId()));
                chain.doFilter(request, response);
            } else {
//                System.out.print("Error, redirecting to login page...");
                report += "Error, redirecting to login page...\n";
                res.sendRedirect(req.getContextPath() + "/login.jsp");
            }
        } else {
//            System.out.print("Error, redirecting to login page...");
            report += "Error, redirecting to login page...\n";
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
//        System.out.println("---------------------------");
        report += "---------------------------";
        System.out.println(report);
    }
}
