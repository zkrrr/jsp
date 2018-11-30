package org;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestFourthTwo extends HttpServlet {
    public static final double PAI = 3.14;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String di = req.getParameter("d");
        double d = Double.parseDouble(di);
        double c = 2*d*PAI;
        double s = PAI*d*d;
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"zh\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<title>calculator</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<P>圆的半径:"+d+"</P>");
        printWriter.println("<P>圆的周长:"+c+"</P>");
        printWriter.println("<P>圆的面积:"+s+"</P>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
