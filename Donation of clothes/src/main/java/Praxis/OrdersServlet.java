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

@WebServlet(urlPatterns="/orders.do")
public class OrdersServlet extends HttpServlet
{
	JdbcTest db = new JdbcTest();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		

		try {
			if(db.getOrdered()==null)
			{
				request.getRequestDispatcher("/WEB-INF/Views/orderFalse.jsp").forward(request, response);	
			}
			else if(db.getOrdered().equals("1"))
			{

					request.setAttribute("charity", db.getCharity());
					request.setAttribute("shirts", db.getShirts());
					request.setAttribute("shoes", db.getShoes());
					request.setAttribute("pants", db.getPants());
					request.setAttribute("dresses", db.getDresses());
					request.setAttribute("others", db.getOthers());
					request.getRequestDispatcher("/WEB-INF/Views/orderTrue.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		response.sendRedirect("/welcome.do");
	}
}


/*
 * welcome.do: First page, welcome and login. Redirects to home or sign up servlet.
 * signup.do: Creating a new user. Updates DB and redirects to welcome servlet.
 * home.do: Takes values of no of clothes. Updates DB. Redirects to orgselect servlet.
 * orgselect.do: Takes value for which organization selected. Updates DB. Redirects to final servlet.
 * final.do: Displays user's selected number of clothes and org.
*/
