package com.nfs.bank_co.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
public class SessionLocaleFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter("sessionLocale") != null) {
            System.out.println("REQ LOCAL" + req.getParameter("sessionLocale"));
            req.getSession().setAttribute("lang", req.getParameter("sessionLocale"));
        } else {
            System.out.println("REQ LOCAL NO FOUND");
        }

        chain.doFilter(request, response);
    }

    public void destroy() {}

    public void init(FilterConfig arg0) throws ServletException {}

}