package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		if(session != null)	{
			
			session.invalidate();
			
			//Check that session has been invalidated
			session = request.getSession(false);
			
			if(session == null)	{
				System.out.println("Success, current user logged out!");
				response.sendRedirect("loginForm.jsp");
			}
			else {
				response.setContentType("text/html");
				PrintWriter myPrintWriter = response.getWriter();
				
				myPrintWriter.print("<html>");
				myPrintWriter.print("<body>");
				myPrintWriter.print("An error has occurred!<br/><br/>");
				myPrintWriter.print("<a href='homepage.jsp'>Return to hompage</a>");
				myPrintWriter.print("</body>");
				myPrintWriter.print("</html>");
				
			}
		}
		
		else {
			response.sendRedirect("loginForm.jsp");
		}
	}
}
