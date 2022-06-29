package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Review;
import dao.PopulateData;

public class SearchResultServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		
		if(session != null)	{
			
			//response.setContentType("text/html");
			//PrintWriter myPrintWriter = response.getWriter();
			
			List<Product> allProducts = PopulateData.listOfProducts;
			List<Product> foundProducts = new ArrayList<Product>();
			
			String query = request.getParameter("queryItem");
			
			//Find matching product
			for(Product p : allProducts)	{
				String projectName = p.getName();
				if(projectName.contains(query)) {
					foundProducts.add(p);
				}
			}
			
			session.setAttribute("searchResult", foundProducts);
			response.sendRedirect("searchResult.jsp");
		}
		
		else {
			response.sendRedirect("loginForm.jsp");
		}
	}
}
