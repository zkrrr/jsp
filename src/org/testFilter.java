package org;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class testFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = (String) request.getSession().getAttribute("name");
        if (username==null){
            response.sendRedirect("/test43/login.jsp");
        }
        else {
            chain.doFilter(request,response);
        }
    }
}
