package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.PopulateData;

public class ExecuteUpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null)	{
			
			response.setContentType("text/html");
			PrintWriter myPrintWriter = response.getWriter();
			
			String username = (String) session.getAttribute("username");
			String currentPassword = (String) request.getParameter("currentPassword");
			String newPassword = (String) request.getParameter("newPassword");
			String newPassword2 = (String) request.getParameter("newPassword2");
			
			myPrintWriter.print("<html><body>");
			
			//............ Validate current password and update password accordingly ............
			
			Map<String, User> listOfUsers = PopulateData.listOfUsers;
			User userObj = listOfUsers.get(username);
			
			if(userObj.getPassword().equals(currentPassword))	{
				
				if(newPassword.equals(newPassword2))	{
					userObj.setPassword(newPassword);
					listOfUsers.put(username, userObj);
					myPrintWriter.print("Password update successful<br/><br/>");
					myPrintWriter.print("<a href='loginForm.jsp'>Click for login page</a><br/>");
					System.out.println("Update password successful! New password: "+ userObj.getPassword());
				}
				
				else {
					myPrintWriter.print("New password does not match<br/><br/>");
					myPrintWriter.print("<a href='updatePasswordForm.jsp'>Click to try again</a><br/>");

				}
			}
			
			else {
				myPrintWriter.print("Invalid current password");
			}
			
			myPrintWriter.print("</body>");
			myPrintWriter.print("</html>");
		}
		
		else {
			response.sendRedirect("loginForm.jsp");
		}
	}
}
