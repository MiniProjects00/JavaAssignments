<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<style>
			div.header_div { 
				border: 2px solid blue; 
				border-radius: 5px;
				background-color: lightblue; 
				height: auto; 
				width: 97%;
				padding: 20px;
			}
		</style>
	</head>
	<body>
		<div class="header_div">
		
			<% String username = (String) session.getAttribute("username"); %>
			<h1>Welcome <%=username%></h1>
			
			<a href="homepage2.jsp">Homepage</a><br/>
			<a href="updatePasswordForm.jsp">Update password</a><br/>
			<a href="orderHistory.jsp">Order history</a><br/>
			<a href="viewCart.jsp">View cart</a><br/>
			<a href="LogoutServlet">Logout</a><br/>
			
			<br/>

			<form action="SearchResultServlet" method="post">
				<Input type="text" placeholder="Search..." name="queryItem">
				<button>Search</button>
			</form>
		</div>
	</body>
</html>