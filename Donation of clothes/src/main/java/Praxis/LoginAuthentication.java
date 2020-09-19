package Praxis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

public class LoginAuthentication {
	public boolean IsUserValid(String username, String password) throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String u, p;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			
			
			// 4. Process the result set
			while (myRs.next()) 
			{//myRs.next() -> changes b/n rows. returns true for each row
				u=myRs.getString("user");
				p=myRs.getString("password");

				if(u.equals(username)&&(p.equals(password)))
				{
					return true;
				}

			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
		return false;
	}

}
