package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

public class AddToCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		
		if(session != null)	{
			
			response.setContentType("text/html");
			PrintWriter myPrintWriter = response.getWriter();
			
			myPrintWriter.print("<html>");
			myPrintWriter.print("<body>");
			
			String pId = request.getParameter("productId");
			int productId = Integer.parseInt(pId);
			
			List<Product> allItems = PopulateData.listOfProducts;

			List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");
			for(Product p : allItems)	{
				if(p.getProductId() == productId) {
					cartItems.add(p);
					System.out.println("Product added");
					myPrintWriter.print("Product added<br/><br/>");
					myPrintWriter.print("<a href='homepage2.jsp'>Return to homepage</a><br/>");
					
					myPrintWriter.print("</body>");
					myPrintWriter.print("</html>");
					break;
				}
			}
		}	
	}
}
