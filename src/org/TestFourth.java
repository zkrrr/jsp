package org;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class TestFourth extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"zh\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<title>userlogin</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<B>欢迎"+req.getParameter("username")+"登录</B>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"zh\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<title>userlogin</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<B>用户登录</B>");
        printWriter.println("<form method=\"post\" action=\"test41\">");
        printWriter.println("<P>用户名:<input type=\"text\" name=\"username\"></P>");
        printWriter.println("<P>密码:<input type=\"password\" name=\"password\"></P>");
        printWriter.println("<P><input type=\"submit\" value=\"登录\"><input type=\"reset\" value=\"重置\"></P>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
