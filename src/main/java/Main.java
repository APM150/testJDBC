import java.sql.*;
import java.util.ArrayList;

import static java.time.ZoneOffset.UTC;

public class Main {
    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/blurts?autoReconnet=true&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
//        String user = "root";
//        String password = "jjxuyaosheng1027";
//        try {
//            Connection myConn = DriverManager.getConnection(url, user, password);
//            Statement myStmt = myConn.createStatement();
//            String sql = "select * from blurts.user";
//            ResultSet rs = myStmt.executeQuery(sql);
//            while (rs.next()) {
//                System.out.println(rs);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        ReadFromDB reader = new ReadFromDB();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("id");
        arr.add("title");
        System.out.println(reader.read(arr, "movies"));
    }
}
