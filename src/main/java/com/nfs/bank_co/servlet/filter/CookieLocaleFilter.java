package com.nfs.bank_co.servlet.filter;

import com.nfs.bank_co.utils.locals.LocalsUtility;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebFilter(filterName = "CookieLocaleFilter", urlPatterns = {"/*"})
public class CookieLocaleFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        Cookie[] cookie_jar = req.getCookies();
        boolean cookieCreationRequired = false;

        if (cookie_jar != null) {

            boolean cookieFound = false;

            for (Cookie cookie : cookie_jar) {
                if (cookie.getName().equals("lang")) {
                    cookieFound = true;
                    break;
                }
            }

            if (!cookieFound) {
                cookieCreationRequired = true;
            }

        } else {
            cookieCreationRequired = true;
        }
        if (cookieCreationRequired) {
            Locale browserLocale = LocalsUtility.getBrowserLanguage(req,res);
            Cookie newCookie = new Cookie("lang", browserLocale != null ? browserLocale.toString() : "fr");
            res.addCookie(newCookie);
        }
        chain.doFilter(request, response);
    }
}
