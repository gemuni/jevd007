<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./APP/JS/app.js"></script>
</head>
<body>
	<h1>LOGIN</h1>
	<form name="LoginForm" action="LoginServlet" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="txtname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="txtpass"></td>
			</tr>
			<tr>
				<td></td>
				<td><input onclick="doLogin()" type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>