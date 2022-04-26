package com.nfs.bank_co.servlet.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nfs.bank_co.utils.AuthenticationUtility;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/dashboard.jsp"})
public class AuthorizationFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filtre authorization");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String token = AuthenticationUtility.getCookieByName(req.getCookies(), "token");
        if (token != null) {
            boolean isTokenValid = AuthenticationUtility.checkTokenValidity(token);
            if (isTokenValid) {
                System.out.println("Token Valide");
                chain.doFilter(request, response);
            } else {
                // TODO Redirection vers page de connexion ou landing page
                System.out.println("Token Invalide");
                res.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            System.out.println("Token Introuvable");
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
