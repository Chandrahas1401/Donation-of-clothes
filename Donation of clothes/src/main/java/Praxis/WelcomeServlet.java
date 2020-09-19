package Praxis;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/welcome.do")
public class WelcomeServlet extends HttpServlet
{
	static String uname;
	private LoginAuthentication service = new LoginAuthentication();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		request.getRequestDispatcher("/WEB-INF/Views/welcome.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		uname = request.getParameter("name");
		String password = request.getParameter("password");
		boolean IsUserValid;
		try {
			IsUserValid = service.IsUserValid(uname, password);
			if(IsUserValid) 
			{	
				//actual parameter1=variable for JSP, parameter2 =thing from Java file
				request.setAttribute("name", uname);
				//request.setAttribute("password", password);
				response.sendRedirect("/home.do");
			}
			else
			{	
				request.setAttribute("error", "Invalid User. Please check your login credentials");
				request.getRequestDispatcher("/WEB-INF/Views/welcome.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

/*
 * welcome.do: First page, welcome and login. Redirects to home or sign up servlet.
 * signup.do: Creating a new user. Updates DB and redirects to welcome servlet.
 * home.do: Takes values of no of clothes. Updates DB. Redirects to orgselect servlet.
 * orgselect.do: Takes value for which organization selected. Updates DB. Redirects to final servlet.
 * final.do: Displays user's selected number of clothes and org.
*/
