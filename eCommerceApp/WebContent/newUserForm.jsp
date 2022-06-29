<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Create account</title>
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
			<h1>Create Account</h1>
			<hr>
			<form action="executeAddNewUser.jsp">
				<h4>Username</h4> 			<input type="text" size="32" name="username"><br/>
				<h4>Password</h4> 			<input type="password" size="32" name="password"><br/>
				<h4>Security question</h4>	<input type="text" size="32" name=securityQuestion><br/>
				<h4>Answer</h4> 			<input type="text" size="32" name="securityQuestionAnswer"><br/><br/><br/>
											<input type ="submit" value="Submit"><br/>
			</form>
		</div>
	
	</body>
</html>