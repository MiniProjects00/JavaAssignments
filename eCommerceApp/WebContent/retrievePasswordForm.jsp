<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="dao.PopulateData"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Retrieve password</title>
		<style>
			div {
				border: 4px solid black;
				border-radius: 15px;
				padding: 30px;
				margin: 20px;
				width: 350px;
			}
			
			input {
				font-size: 14pt;
			}
		</style>
	</head>
	<body>
		<div>
		
		<%
			Map<String, User> listOfUsers = PopulateData.listOfUsers;
			List<String> questions = new ArrayList<String>();
			
			for(Map.Entry<String, User> entry : listOfUsers.entrySet()) {
				
				User userObj = entry.getValue();
				String question = userObj.getSecurityQuestion();
				questions.add(question);
			}
		%>
			
			<h1>Retrieve Password</h1>
			<hr>
			<form action ="RetrievePasswordServlet" method = "post">
				<h3>Username</h3>					<input type="text" size="30" name="username"><br/>
				<h3>Select Security question</h3>	<select>
													<%
														for(String q:questions) {
													%>
															<option><%=q%></option>
													<%
														}
													%>
													</select><br/>
				<h3>Enter Answer</h3>				<input type="text" size="30" name="securityQuestionAnswer"/><br/><br/><br/>
													<input type = "submit" value = "Submit"><br/>
			</form>
		</div>
	</body>
</html>