import java.sql.*;

class MysqlCon {
    public static void mydata(String name, int age,long phone_no, String address,  String collage_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user="root";
            String password="root";
            String url="jdbc:mysql://localhost:3306/syncintern_db";

            Connection con = DriverManager.getConnection(url, user, password);
           String st="insert into my_table values("+"'"+name+"'"+","+age+","+phone_no+","+"'"+address+"'"+","+"'"+collage_name+"'"+")";
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(st);
            System.out.println(rs);
            con.close();
        } catch (Exception e) {
            System.out.println("connection error!!!");
        }
    }
}