package servlet;

import dao.JdbcConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Connection connection = JdbcConnection.getConnection();
        if (connection!=null) {
            String sql = "update user set password=? where username=?;";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, password);
                preparedStatement.setString(2, username);
                preparedStatement.executeUpdate();
                connection.close();
                resp.sendRedirect("/test51/SearchAndModify.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
