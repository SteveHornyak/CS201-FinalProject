import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		String db = "jdbc:mysql://localhost:3306/CSCI201_Final_Database";
	    String user = "root";
	    String pwd = "root";
    	Connection conn = null;
    	try {
    		conn = DriverManager.getConnection(db,user,pwd);
    		System.out.println("Success");
    	}
    	catch (SQLException e){
    		System.out.println("Failed");
    		e.printStackTrace();
    	}
	}
}
