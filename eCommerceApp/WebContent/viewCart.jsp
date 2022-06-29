<%@page import="java.util.*"%>
<%@page import="model.Product"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cart</title>
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
		<center><h1>Cart</h1></center><br/>
		
		<%
			List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");
			if(cartItems.size() == 0)	{
		%>
				<h3>Cart is empty</h3>
			
		<%	}
			else {
		%>
				<table>
					<tr>
						<th><h3>Name</h3></th>
						<th><h3>Cost</h3></th>
						<th><h3>Description</h3>
					</tr>
				
		<%		for(Product p : cartItems) {
						
						String productName = p.getName();
						int productCost = p.getPrice();
						String productDescription = p.getDescription();
		%>
					<tr>
						<td><%=productName%></td>
						<td><%=productCost%></td>
						<td><%=productDescription%></td>
					</tr>
		<%		} 
		%>
				</table>		
		
		<% 	}
		%>
	</body>
</html>