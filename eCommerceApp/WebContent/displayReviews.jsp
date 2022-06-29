<%@page import="model.Review" %>
<%@page import="java.util.List" %>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Reviews</title>
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
		<%@ include file="header.jsp"%>
		<hr/>
		
		<% String productName = (String) session.getAttribute("productName"); %>
		<center><h1>Reviews for <%=productName%></h1></center><br/>
		<table>
			<tr>
				<th><h3>Rating</h3></th>
				<th><h3>Comment</h3></th>
			</tr>
			
			<%
				List<Review> reviews = (List<Review>) session.getAttribute("reviewsForProduct");
				
				for(Review r : reviews)	{
				
					int rating = r.getRating();
					String comment = r.getReviewDescription();
			%>
					<tr>
						<td><%=rating%></td>
						<td><%=comment%></td>
					</tr>
			<%
				}
			%>
	</table>
</body>
</html>