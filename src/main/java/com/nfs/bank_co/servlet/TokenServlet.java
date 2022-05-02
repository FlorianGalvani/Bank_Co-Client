package com.nfs.bank_co.servlet;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TokenServlet", urlPatterns = {"/token"})
public class TokenServlet extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);

        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("token"))
                    token = cookie.getValue();
            }
            if (token != null){

                try {
                    Algorithm algorithm = Algorithm.HMAC256("secret"); // TODO Modifier le secret
                    JWTVerifier verifier = JWT.require(algorithm)
                            .withIssuer("auth0")
                            .build(); //Reusable verifier instance
                    DecodedJWT jwt = verifier.verify(token);
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    out.print("true");
                    out.flush();
                } catch (JWTVerificationException e) {

                    response.addCookie(new Cookie("token", null));
                    response.addCookie(new Cookie("id", null));
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    out.print("false");
                    out.flush();
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
