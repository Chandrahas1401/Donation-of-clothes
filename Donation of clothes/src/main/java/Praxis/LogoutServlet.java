package Praxis;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout.do")
public class LogoutServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/Views/welcome.jsp").forward(request, response);;
		
	}
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
}