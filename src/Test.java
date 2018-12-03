import dao.JdbcConnection;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String username = "aa";
        String password = "bb";
        try {
            String sql = "select * from user;";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","zkrjyf");
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1,username);
//            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
