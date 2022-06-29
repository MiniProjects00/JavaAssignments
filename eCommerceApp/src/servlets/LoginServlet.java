package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PopulateData;
import model.Product;
import model.User;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = validateLogin(username, password);
		
		if(user!=null)	{
			
			System.out.println("User found!");
			
			HttpSession session = request.getSession(true);
			
			session.setAttribute("username", user.getUsername());
			session.setAttribute("listOFPurchasedProducts", user.getPurchasedProducts());
			
			List<Product> cartItems = new ArrayList<Product>();
			session.setAttribute("cartItems", cartItems);
			response.sendRedirect("homepage2.jsp");
			
		}
		
		else {
			System.out.println("Invalid credentials!");
			response.sendRedirect("loginForm.jsp");
		}
	}
	
	public User validateLogin(String username, String password)	{
		
		Map<String, User> allRegisteredUsers = PopulateData.retrieveUsers();
		
		User userObj = allRegisteredUsers.get(username);

		if(userObj != null)	{
			String passwordFromList = userObj.getPassword();
			
			if(password.equals(passwordFromList))	{
				return userObj;
			}
		}
		return null;
	}
}
