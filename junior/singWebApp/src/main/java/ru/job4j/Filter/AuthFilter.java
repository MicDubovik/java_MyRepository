package ru.job4j.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Katy on 21.05.2017.
 */
public class AuthFilter implements Filter {
    /**
     * init.
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * doFilter.
     * @param req
     * @param resp
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) req);

        if (request.getRequestURI().contains("Signin")) {
            chain.doFilter(req, resp);
        } else if (request.getRequestURI().contains("Register")) {
            chain.doFilter(req, resp);

        }

        else {
            HttpSession session = request.getSession();
            synchronized (session) {
                if (session.getAttribute("login") == null) {
                    HttpServletResponse response = ((HttpServletResponse) resp);
                    response.sendRedirect(String.format("%s/Signin", request.getContextPath()));
                    return;
                }
            }
            chain.doFilter(req,resp);
        }

    }

    /**
     * destroy.
     */
    @Override
    public void destroy() {

    }
}
