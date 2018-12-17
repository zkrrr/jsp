package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcConnection {
    public static final String jdbcDriver="com.mysql.jdbc.Driver";
    public static final String connect = "jdbc:mysql://localhost:3306/jsp";
    public static final String user = "root";
    public static final String password = "zkrjyf";
    public static Connection getConnection(){
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            return DriverManager.getConnection(connect,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
