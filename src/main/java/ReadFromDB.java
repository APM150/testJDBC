import org.json.simple.JSONObject;

import java.sql.*;
import java.util.ArrayList;

public class ReadFromDB {
    String url = "jdbc:mysql://localhost:3306/moviedb?autoReconnet=true&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "123456";

   public JSONObject read(ArrayList<String> col, String table) {
       JSONObject result = new JSONObject();
       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection myConn = DriverManager.getConnection(url, user, password);
           Statement myStmt = myConn.createStatement();
           String sql = "select * from moviedb."+table;
           ResultSet rs = myStmt.executeQuery(sql);
           int index = 0;
           while (rs.next()) {
               JSONObject row = new JSONObject();
               for (String c: col) {
                   row.put(c, rs.getString(c));
               }
               result.put(index++, row);
           }
       } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
       }
       return result;
   }
}
