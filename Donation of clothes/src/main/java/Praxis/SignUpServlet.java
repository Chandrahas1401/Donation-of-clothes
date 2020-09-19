package Praxis;

import java.sql.*;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/signup.do")
public class SignUpServlet extends JdbcTest
{
	String user;
	String pass;
	String email;
	String address;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		request.getRequestDispatcher("/WEB-INF/Views/signup.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{

		user = request.getParameter("user");
		pass = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		email = request.getParameter("email");
		address = request.getParameter("address");
		String num = request.getParameter("num");

		try {
			userAdd(user, pass, fname, lname, email, address, num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/welcome.do");
	}
}

class JdbcTest extends WelcomeServlet
{
	
	void userAdd(String user, String pass, String fname, String lname, String email, String address, String num) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			int rowsAffected = myStmt.executeUpdate("insert into OJ_2" + "(user, password, fname, lname, email, address, num)" + "values" + "('"+user+"', '"+pass+"', '"+fname+"', '"+lname+"', '"+email+"', '"+address+"', '"+num+"')");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from signupcred");
			
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
	}
	void clothesAdd(String shirts, String shoes, String pants, String dresses, String others) throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("ClothesAdd connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			int rowsAffected = myStmt.executeUpdate("update OJ_2 SET shirts='"+shirts+"', shoes='"+shoes+"', pants='"+pants+"', dresses='"+dresses+"', others='"+others+"' WHERE user='"+uname+"'");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
	}
	void orgAdd(String org) throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("OrgAdd connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			System.out.println(org);
			int rowsAffected = myStmt.executeUpdate("update OJ_2 SET charity='"+org+"' WHERE user='"+uname+"'");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
	}
	String getCharity() throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("getCharity connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			//System.out.println(org);
			int rowsAffected = myStmt.executeUpdate("update OJ_2 SET ordered='1' WHERE user='"+uname+"'");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			while(myRs.next())
			{
				System.out.println(myRs.getString("user"));
				if(myRs.getString("user").equals(uname))
				{
					System.out.println(myRs.getString("charity"));
					return (myRs.getString("charity"));
				}
			}
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
		return null;
	}
	String getShirts() throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("getCharity connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			//System.out.println(org);
			//int rowsAffected = myStmt.executeUpdate("update OJ_2 SET charity='"+org+"' WHERE user='"+uname+"'");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			while(myRs.next())
			{
				System.out.println(myRs.getString("user"));
				if(myRs.getString("user").equals(uname))
				{
					System.out.println(myRs.getString("charity"));
					return (myRs.getString("shirts"));
				}
			}
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
		return null;
	}
	String getShoes() throws SQLException

	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("getCharity connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			//System.out.println(org);
			//int rowsAffected = myStmt.executeUpdate("update OJ_2 SET charity='"+org+"' WHERE user='"+uname+"'");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			while(myRs.next())
			{
				System.out.println(myRs.getString("user"));
				if(myRs.getString("user").equals(uname))
				{
					System.out.println(myRs.getString("charity"));
					return (myRs.getString("shoes"));
				}
			}
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
		return null;

	}
	String getPants() throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("getCharity connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			//System.out.println(org);
			//int rowsAffected = myStmt.executeUpdate("update OJ_2 SET charity='"+org+"' WHERE user='"+uname+"'");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			while(myRs.next())
			{
				System.out.println(myRs.getString("user"));
				if(myRs.getString("user").equals(uname))
				{
					System.out.println(myRs.getString("charity"));
					return (myRs.getString("pants"));
				}
			}
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
		return null;
	
	}
	String getDresses() throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("getCharity connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			//System.out.println(org);
			//int rowsAffected = myStmt.executeUpdate("update OJ_2 SET charity='"+org+"' WHERE user='"+uname+"'");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			while(myRs.next())
			{
				System.out.println(myRs.getString("user"));
				if(myRs.getString("user").equals(uname))
				{
					System.out.println(myRs.getString("charity"));
					return (myRs.getString("dresses"));
				}
			}
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
		return null;
	
	}
	String getOthers() throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("getCharity connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			//System.out.println(org);
			//int rowsAffected = myStmt.executeUpdate("update OJ_2 SET charity='"+org+"' WHERE user='"+uname+"'");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			while(myRs.next())
			{
				System.out.println(myRs.getString("user"));
				if(myRs.getString("user").equals(uname))
				{
					System.out.println(myRs.getString("charity"));
					return (myRs.getString("others"));
				}
			}
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
		return null;
	
	}
	String getOrdered() throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database    jdbc url								user		p/w
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("getCharity connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// X. Inserting a new row
			//System.out.println(org);
			//int rowsAffected = myStmt.executeUpdate("update OJ_2 SET charity='"+org+"' WHERE user='"+uname+"'");	

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from OJ_2");
			while(myRs.next())
			{
				System.out.println(myRs.getString("user"));
				if(myRs.getString("user").equals(uname))
				{
					System.out.println(myRs.getString("charity"));
					return (myRs.getString("ordered"));
				}
			}
			
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		finally 
		{
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
		return null;
	
	}
	
}

/*
 * welcome.do: First page, welcome and login. Redirects to home or sign up servlet.
 * signup.do: Creating a new user. Updates DB and redirects to welcome servlet.
 * home.do: Takes values of no of clothes. Updates DB. Redirects to orgselect servlet.
 * orgselect.do: Takes value for which organization selected. Updates DB. Redirects to final servlet.
 * final.do: Displays user's selected number of clothes and org.
*/
