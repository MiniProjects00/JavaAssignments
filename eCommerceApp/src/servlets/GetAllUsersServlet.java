package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PopulateData;
import model.Product;
import model.User;


public class GetAllUsersServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	//............................................... doGet(): all users ................................................

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null)	{
			
			response.setContentType("text/html");
			PrintWriter myPrintWriter = response.getWriter();
			
			Map<String, User> allUsers = PopulateData.listOfUsers;
					
			myPrintWriter.print("<html>");
			myPrintWriter.print("<body>");
			
			if(allUsers.size() != 0) {
				
				for (Map.Entry<String,User> entry : allUsers.entrySet()) {
					
					User userObj = entry.getValue();

					String username = userObj.getUsername();
					String password = userObj.getPassword();
					String securityQuestion = userObj.getSecurityQuestion();
					String securityQuestionAnswer = userObj.getSecurityQuestionAnswer();
					
					myPrintWriter.print("<h2>Username: " + username + "</h2><br/>");
					myPrintWriter.print("Password: " + password + "<br/>");
					myPrintWriter.print("Security question: " + securityQuestion + "<br/>");
					myPrintWriter.print("Answer: " + securityQuestionAnswer + "<br/>");
					myPrintWriter.print("<br/><hr/>");
					
					//Print list of products purchased
					List<Product> listOfPurchasedProducts = userObj.getPurchasedProducts();
					if(listOfPurchasedProducts != null) {
						
						int counter = 0;
						for(Product p : listOfPurchasedProducts)	{
							counter++;
							myPrintWriter.print("Product purchased" + counter + ": " + p + "<br/>");
						}
						
						myPrintWriter.print("<br/><hr/>");
					}
					
					else	{
						myPrintWriter.print("Products purchased: No products purchased <br/>");
					}
					
					
					//Print items in cart for single logged in user
					List<Product> cart = (List<Product>) session.getAttribute("cartItems");
					
					if(cart.size() != 0) {
						
						for(Product p : cart)	{
							myPrintWriter.print("In cart: " + p + "<br/>");
						}
						
						myPrintWriter.print("<br/><hr/>");
						
					}
					
					else	{
						System.out.println("Cart empty");
						myPrintWriter.print("Cart empty<br/>");
						myPrintWriter.print("<br/><hr/>");
					}
				}
			}
			
			else	{
				myPrintWriter.print("No users");
			}
			
			myPrintWriter.print("</body>");
			myPrintWriter.print("</html>");
		}
		
		else {
			response.sendRedirect("loginForm.jsp");
		}
	}
}
