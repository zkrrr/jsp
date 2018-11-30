import dao.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        Connection connection = JdbcConnection.getConnection();
        if (connection!=null) {
            String sql = "select password from user where username=?";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "admin");
                ResultSet resultSet = preparedStatement.executeQuery();
                String passowrd="";
                while (resultSet.next()) {
                    passowrd = resultSet.getString("password");
                }
                System.out.println(passowrd);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
