<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Create account</title>
	</head>
	<body>
	
			<!-- Create user object -->
			<jsp:useBean id="UserClassObject" class="model.User" scope="session"></jsp:useBean>
			<jsp:setProperty property="*" name="UserClassObject"/>
	
	
			<!-- Java code, add to DB -->
			<% boolean status = UserClassObject.addNewUser();%>
			
			
			<!-- Print on browser -->
			<h2>Account created: <%=status%> </h2><br/><br/>		
			<a href="loginForm.jsp">Click for login page</a><br/>
			
			<hr/>
		
			Information: <br/><br/>
			Username: 	 		<jsp:getProperty property="username" name="UserClassObject"/> <br/>
			Password: 		 	<jsp:getProperty property="password" name="UserClassObject"/> <br/>
			Security question: 	<jsp:getProperty property="securityQuestion" name="UserClassObject"/> <br/>
			Answer: 	 		<jsp:getProperty property="securityQuestionAnswer" name="UserClassObject"/> <br/>
	
	</body>
</html>