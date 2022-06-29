<%@page import="java.util.*"%>
<%@page import="model.Product"%>
<%@page import="model.Review"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Search Result</title>
		<style>
			table {
			  	margin-left: auto;
  				margin-right: auto;
			}
			tr {
				border: 1px solid grey;
			}
			
			th {
	 			padding: 10px;
	 			background-color: silver;
	 			}
	 			
			td {
				text-align: center;
				width: 350px;
				height: 50px;
				padding: 10px;
				border: 1px solid grey;
			}
		</style>
	</head>
	<body>
		<%@include file="header.jsp"%>
		<hr/>
		<center><h1>Search Result</h1></center><br/>
		<%
			List<Product> cartItems = (List<Product>) session.getAttribute("searchResult");
			if(cartItems.size() == 0)	{
		%>
				<h3>Cart is empty</h3>
			
		<%	}
			else {
		%>
				<table>
					<tr>
						<th><h3>Product</h3></th>
						<th><h3>Product description</h3></th>
						<th><h3>Cost</h3></th>
						<th><h3>Rating</h3></th>
						<th><h3>Review</h3></th>
						<th><h3>Add to cart</h3></th>
					</tr>
		<%			
					for(Product p : cartItems)	{
					
						int productId = p.getProductId();
						String productName = p.getName();
						int productCost = p.getPrice();
						String productDescription = p.getDescription();
		%>
						<tr>
							<td><%=productName%></td>
							<td><%=productDescription%></td>
							<td>$<%=productCost%></td>
						
		<%					List<Review> productReviews = p.getListOfProductReview();
						
							if(productReviews != null)	{
								int reviewStar = productReviews.get(0).getRating();
		%>
								<td><%=reviewStar%></td>
								<td><a href="ExecuteRetrieveReviewServlet?productId=<%=productId%>" target="_parent"><button>View Reviews</button></a></td>
		<%					}
							else {
		%>			
								<td>No rating</td>
								<td>No review</td>
		<%					}
		%>		
							<td><a href="AddToCartServlet?productId=<%=productId%>" target="_parent"><button>Add to cart</button></a></td>
						</tr>
		<%
					}
				}
				%>
		</table>
	</body>
</html>

