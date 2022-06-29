<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<style>
			div {
				border: 4px solid black;
				border-radius: 15px;
				padding: 30px;
				margin: 20px;
				width: 300px;
				}
			
			td {
				width: 150px;
				padding: 10px;
			}
			
			input {
				font-size: 14pt;
			}
		</style>
	</head>
	<body>
		<div>
			<h1>Login</h1>
			
			<hr>
			
			<form action ="LoginServlet" method = "post">
				<h3>Username</h3><input type = "text" size="28" name = "username"><br/>
				<h3>Password</h3><input type = "password" size="28" name = "password"><br/><br/><br/>
				<input type = "submit" value = "Login"><br/>
			</form>

			<br/><br/> 
		
			<table>
				<tr>
					<td><a href="newUserForm.jsp">Register</a></td>
					<td><a href="retrievePasswordForm.jsp">Forgot password</a></td>
				</tr>
			</table>
		</div>
	</body>
</html>