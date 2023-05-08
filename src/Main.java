import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost/java";
            Connection conn= DriverManager.getConnection(url,"root","root");
            System.out.println("connection success");
            Statement statement = conn.createStatement();
                 //statement.executeUpdate("INSERT into student(id,name) values(2,'samik')");
            statement.executeUpdate("UPDATE student set name='mingmar' where id=2");
           statement.executeUpdate("Delete from student where id =1");
           ResultSet set= statement.executeQuery("SELECT * from student");
            while(set.next()){
                System.out.println(set.getInt("id"));
                System.out.println(set.getString("name"));
                System.out.print("\n");
            }

        } catch (ClassNotFoundException  | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}