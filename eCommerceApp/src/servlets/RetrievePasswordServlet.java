package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PopulateData;
import model.User;

public class RetrievePasswordServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null)	{
			
			response.setContentType("text/html");
			PrintWriter myPrintWriter = response.getWriter();
			
			String queryUsername = (String) request.getParameter("username");
			String querySecurityQuestionAnswer = (String) request.getParameter("securityQuestionAnswer");
			User userObjReturned = PopulateData.retrieveSingleUser(queryUsername);
			
			myPrintWriter.print("<html>");
			myPrintWriter.print("<body>");
			
			if(userObjReturned.equals(null))	{
				System.out.println("Invalid username");
				myPrintWriter.print("Invalid username");
				response.sendRedirect("retrievePasswordForm.jsp");
			}
			
			else {
				
				if(userObjReturned.getSecurityQuestionAnswer().equals(querySecurityQuestionAnswer)) {
					String password = userObjReturned.getPassword();
					System.out.println("Your password is: " + password);
					myPrintWriter.print("Your password is: " + password + "<br/><br/>");
					myPrintWriter.print("<a href='loginForm.jsp'>Click for login page</a><br/>");
				}
				
				else {
					System.out.println("Incorrect answer to security question");
					myPrintWriter.print("Incorrect answer to security question");
					response.sendRedirect("requestPasswordForm.jsp");
				}
			}
			
			myPrintWriter.print("</body>");
			myPrintWriter.print("</html>");
			
		}
		
		//User not logged in
		else {
			response.sendRedirect("loginForm.jsp");
		}
	}
}
