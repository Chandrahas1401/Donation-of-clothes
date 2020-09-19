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

@WebServlet(urlPatterns="/home.do")
public class HomeServlet extends HttpServlet
{
	JdbcTest ob = new JdbcTest();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		request.setAttribute("name", ob.uname);

		request.getRequestDispatcher("/WEB-INF/Views/home.jsp").forward(request, response);;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		String shirts = request.getParameter("shirts");
		String shoes = request.getParameter("shoes");
		String pants = request.getParameter("pants");
		String dresses = request.getParameter("dresses");
		String others = request.getParameter("others");
		request.setAttribute("shirts", shirts);
		request.setAttribute("shoes", shoes);
		request.setAttribute("pants", pants);
		request.setAttribute("dresses", dresses);
		request.setAttribute("others", others);
		try {
			ob.clothesAdd(shirts, shoes, pants, dresses, others);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/OrgSelect.do");
	}
}



/*
 * welcome.do: First page, welcome and login. Redirects to home or sign up servlet.
 * signup.do: Creating a new user. Updates DB and redirects to welcome servlet.
 * home.do: Takes values of no of clothes. Updates DB. Redirects to orgselect servlet.
 * orgselect.do: Takes value for which organization selected. Updates DB. Redirects to final servlet.
 * final.do: Displays user's selected number of clothes and org.
*/
