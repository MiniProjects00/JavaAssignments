<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Product"%>
<%@ page import="model.User"%>
<%@ page import="dao.PopulateData"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Order history</title>
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
				width: 300px;
				height: 50px;
				padding: 10px;
				border: 1px solid grey;
			}
		</style>
	</head>
	<body>
		<%@ include file="header.jsp"%>
		<hr/>
		<center><h1>Past Purchases</h1></center><br/>
		
		<%
			String user = (String) session.getAttribute("username");
			User userObj = PopulateData.listOfUsers.get(user);
			List<Product> listOfPurchasedProducts = userObj.getPurchasedProducts();
			
			if(listOfPurchasedProducts != null)	{
		%>
			<table>
				<tr>
					<th><h3>Name</h3></th>
					<th><h3>Cost</h3></th>
					<th><h3>Description</h3>
				</tr>

		<%		for(Product p : listOfPurchasedProducts)	{
					
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
		<%
			}
			
			else {
		%>	
				<h3>No product purchased</h3>
		<%	}
		%>
		
	</body>
</html>