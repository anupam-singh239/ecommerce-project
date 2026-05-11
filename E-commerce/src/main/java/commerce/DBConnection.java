package commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {


	    public static Connection getConnection() {

	        Connection con = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/ecommerce?useSSL=false&serverTimezone=UTC",
	                "root",
	                "2005"  
	            );

	            System.out.println("DB Connected Successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return con;
	    }
	}
	