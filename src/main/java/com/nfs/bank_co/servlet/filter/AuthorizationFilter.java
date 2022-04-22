package com.nfs.bank_co.servlet.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/customer"})
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

        Cookie[] cookies = req.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("token"))
                    token = cookie.getValue();
            }
            if (token != null){
                System.out.println("token : " + token);
                try {
                    Algorithm algorithm = Algorithm.HMAC256("secret"); // TODO Modifier le secret
                    JWTVerifier verifier = JWT.require(algorithm)
                            .withIssuer("auth0")
                            .build(); //Reusable verifier instance
                    DecodedJWT jwt = verifier.verify(token);
                    System.out.println(jwt.getToken());
                    chain.doFilter(request, response);
                } catch (JWTVerificationException e) {
                    System.out.println(e);
                    // TODO Redirection vers pae de connexion ou landing page
                }
            }
        }
    }
}
