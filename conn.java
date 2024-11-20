package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection connection;
    Statement statement;

    public conn(){
        String url = "jdbc:mysql://localhost:3306/employeemanagement";
        String username = "root";
        String password = "Preet@123";

        //Connection conn = DriverManager.getConnection(url, username, password);



        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","Preet@123");
            //System.out.println("connected to the database");
            statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
