package com.nfs.bank_co.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/dashboard/*"})
public class AuthorizationFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String report = "--- AuthorizationFilter ---\n";
        report += "status : ";
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        if(session != null) {
            if (session.getAttribute("isLogedIn") != null) {
                report += "Ok\n" ;
                String path = req.getRequestURI().substring(req.getContextPath().length());
                chain.doFilter(request, response);
            } else {
                report += "Error, redirecting to login page...\n";
                res.sendRedirect(req.getContextPath() + "/login.jsp");
            }
        } else {
            report += "Error, redirecting to login page...\n";
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
        report += "---------------------------";
    }
}
