package com.nfs.bank_co.servlet.filter;

import com.google.protobuf.MapField;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/nothing"})
public class SessionLocaleFilter implements Filter {
    String supportedLanguages = "en,fr";

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
//        System.out.println("lang : " + req.getSession().getAttribute("lang"));
        if (req.getSession().getAttribute("lang") == null) {
            Enumeration locales = req.getLocales();
            Locale browserLocale = null;
            System.out.println("eeee");
            while (locales.hasMoreElements()) {
                Locale locale = (Locale) locales.nextElement();
                if (supportedLanguages.contains(locale.toString())) {
                    browserLocale = locale;
                    break;
                }
            }
//            System.out.println("browserLocale :"+ browserLocale);
            if (browserLocale != null) {
                req.getSession().setAttribute("lang", browserLocale);
            } else {
                req.getSession().setAttribute("lang", "fr");
            }
        }

        chain.doFilter(request, response);

    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}


