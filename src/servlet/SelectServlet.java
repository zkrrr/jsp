package servlet;

import dao.JdbcConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username="";
        username = req.getParameter("username");
        String password="";
        Connection connection = JdbcConnection.getConnection();
        if (connection!=null) {
            String sql = "select password from user where username=?";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    password = resultSet.getString(1);
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (password.equals("")){
            username="";
        }

        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>\n" +
                "<head>\n" +
                "    <title>SearchAndModify</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div align=\"center\">\n" +
                "    <B>查询和修改用户</B>\n" +
                "</div>\n" +
                "<form  action=\"SelectUser\" method=\"post\" name=\"form1\">\n" +
                "    <table align=\"center\">\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                输入查询的用户名:\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <input type=\"text\" name=\"username\">\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <input type=\"submit\" value=\"查询用户\">\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</form>\n" +
                "\n" +
                "<form name=\"form2\" action=\"UpdateUser\" method=\"post\">\n" +
                "    <table align=\"center\">\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                用户名:\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <input type=\"text\" name=\"username\" value=\""+username+"\" readonly />\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                密码:\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <input type=\"text\" name=\"password\" value=\""+password+"\"  />\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <input type=\"submit\" value=\"修改用户\">\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</form>\n" +
                "<div align=\"center\">\n" +
                "<a href=\"DeleteUser.jsp\">删除用户</a>\n" +
                "</div>\n" +
                "<div align=\"center\">\n" +
                "<a href=\"AddUser.jsp\">添加用户</a>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
