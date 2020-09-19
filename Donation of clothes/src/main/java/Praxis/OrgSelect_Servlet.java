package Praxis;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/OrgSelect.do")
public class OrgSelect_Servlet extends JdbcTest
{
	private WelcomeServlet ws = new WelcomeServlet();
	//change this when implementing DB
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		request.getRequestDispatcher("/WEB-INF/Views/selectorg.jsp").forward(request, response);;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		String org= request.getParameter("charity");
		request.setAttribute("charity", org);
		try {
			orgAdd(org);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/final.do");
	}
}

/*
 * welcome.do: First page, welcome and login. Redirects to home or sign up servlet.
 * signup.do: Creating a new user. Updates DB and redirects to welcome servlet.
 * home.do: Takes values of no of clothes. Updates DB. Redirects to orgselect servlet.
 * orgselect.do: Takes value for which organization selected. Updates DB. Redirects to final servlet.
 * final.do: Displays user's selected number of clothes and org.
*/