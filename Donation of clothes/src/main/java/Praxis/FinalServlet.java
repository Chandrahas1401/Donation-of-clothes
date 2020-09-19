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

@WebServlet(urlPatterns="/final.do")
public class FinalServlet extends HttpServlet
{
	JdbcTest db = new JdbcTest();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{	try {
		request.setAttribute("charity", db.getCharity());
		request.setAttribute("shirts", db.getShirts());
		request.setAttribute("shoes", db.getShoes());
		request.setAttribute("pants", db.getPants());
		request.setAttribute("dresses", db.getDresses());
		request.setAttribute("others", db.getOthers());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		request.getRequestDispatcher("/WEB-INF/Views/final.jsp").forward(request, response);;
	}
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		String t= request.getParameter("charity");
		request.setAttribute("charity", t);
		request.getRequestDispatcher("/WEB-INF/Views/final.jsp").forward(request, response);;
		
	}*/
}

/*
 * welcome.do: First page, welcome and login. Redirects to home or sign up servlet.
 * signup.do: Creating a new user. Updates DB and redirects to welcome servlet.
 * home.do: Takes values of no of clothes. Updates DB. Redirects to orgselect servlet.
 * orgselect.do: Takes value for which organization selected. Updates DB. Redirects to final servlet.
 * final.do: Displays user's selected number of clothes and org.
*/