import dao.JdbcConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.*;

public class Test {
    public static void main(String[] args) throws IOException {
//        String username = "aa";
//        String password = "bb";
//        try {
//            String sql = "select * from user;";
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","zkrjyf");
//            PreparedStatement statement = connection.prepareStatement(sql);
////            statement.setString(1,username);
////            statement.setString(2,password);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()){
//                System.out.println(resultSet.getString(1));
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        ByteBuffer buff=ByteBuffer.allocateDirect(2048);

        String downLoadPath = "jsp.iml";
        File downloadFile = new File(downLoadPath);

        FileChannel inChannel = new FileInputStream(downloadFile).getChannel();

        int bytesRead;
        int position = 0;
        while (-1 != (bytesRead = inChannel.read(buff, position))) {
            inChannel.read(buff, 0);
            System.out.println(bytesRead);
            position += bytesRead;
            buff.clear();

        }

    }
}
