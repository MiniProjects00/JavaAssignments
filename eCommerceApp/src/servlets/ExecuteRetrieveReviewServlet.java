package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Review;
import dao.PopulateData;

public class ExecuteRetrieveReviewServlet extends HttpServlet {
	
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

			for(Product p : allItems)	{
				if(p.getProductId() == productId) {
					
					List<Review> reviewsForProduct = p.getListOfProductReview();
					session.setAttribute("productName", p.getName());
					session.setAttribute("reviewsForProduct", reviewsForProduct);
					response.sendRedirect("displayReviews.jsp");
				}
			}
		}
		
		else {
			response.sendRedirect("loginPage.jsp");
		}
	}
}
