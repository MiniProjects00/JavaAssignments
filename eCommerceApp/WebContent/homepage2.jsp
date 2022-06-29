<%@page import="java.util.*" %>
<%@page import="dao.PopulateData" %>
<%@page import="model.Product" %>
<%@page import="model.Review" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Homepage</title>
		<style>
			tr {
				border: 1px solid grey;
			}
			
			th {
  				padding: 10px;
  				background-color: silver;
  			}
  			
			td {
				text-align: center;
				width: 15%;
				height: 50px;
				padding: 10px;
				border: 1px solid grey;
			}
		</style>
	</head>
	<body>
		<%@ include file="header.jsp"%>
		<hr/>
		<center><h1>Products in stock</h1></center><br/>
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
				List<Product> listOfAvailableProduct = PopulateData.listOfProducts;
				
				for(Product p : listOfAvailableProduct)	{
				
					int productId = p.getProductId();
					String productName = p.getName();
					int productCost = p.getPrice();
					String productDescription = p.getDescription();
			%>
					<tr>
						<td><%=productName%></td>
						<td><%=productDescription%></td>
						<td>$<%=productCost%></td>
					
			<%		List<Review> productReviews = p.getListOfProductReview();
					
					if(productReviews != null)	{
						int reviewStar = productReviews.get(0).getRating();
						String reviewDescription = productReviews.get(0).getReviewDescription();
			%>
						<td><%=reviewStar%></td>
						<td><%=reviewDescription%></td>
			<%			
					}
					else {
			%>			
						<td>No rating</td>
						<td>No review</td>
			<%			
					}
			%>		
						<td><a href="AddToCartServlet?productId=<%=productId%>" target="_parent"><button>Add to cart</button></a></td>
					</tr>
			<%
				}
			%>
		</table>
	</body>
</html>