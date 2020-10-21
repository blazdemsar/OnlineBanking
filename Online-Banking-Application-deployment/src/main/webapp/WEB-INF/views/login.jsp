
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container p-3 my-3 bg-dark text-white" align="center">
		<h1>Welcome to Login Page!</h1>
		<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="home">Return to Home Page</a></li>
				</ul>
			</nav>
	</div>
	<div class="container">
		<h3>Login Below</h3>
		<!-- <p> -->
			<!-- <img src="img/spring.png" height="30" width="30" alt="Spring Logo" /> -->
		<form action="login" method="POST">
			<table>
				<tr>
					<td>User Name: </td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						name="submit" value="Login" class="btn btn-danger" /></td>
				</tr>
			</table>
		</form>
		<br/>
		<h4>If you do not have an account yet, please register <a href="user">here</a>.</h4>
	</div>
</body>
</html>