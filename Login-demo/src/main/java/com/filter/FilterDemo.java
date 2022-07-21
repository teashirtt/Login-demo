package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/webdemo/*")
public class FilterDemo implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String[] urls = {"login.html", "style.css", "script.js","loginServlet","registerServlet"};
        String url = req.getRequestURI().toString();
        for (String u : urls) {
            if (url.contains(u)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        if (username != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("/webdemo/login.html").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}

