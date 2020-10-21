<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div class="container p-3 my-3 bg-dark text-white" align="center">
		<h1>Welcome To Online Banking!</h1>
		<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="account">My Account</a></li>
					<li class="nav-item"><a class="nav-link" href="user">Register</a></li>
					<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
				</ul>
			</nav>
	</div>
	<div class="container" >
		<h2>Using our Online Banking you can:</h2>
		<ul class="list-group list-group-flush">
			<li class="list-group-item">-> Create multiple accounts</li>
			<li class="list-group-item">-> Review your transactions</li>
			<li class="list-group-item">-> Deposit/Withdraw money</li>
			<li class="list-group-item">-> Transfer money between accounts</li>
			<li class="list-group-item">-> Select between our partner branches</li>
		</ul>
		<br/>
		<h4>Existing customers can login using <a href="login">this</a> site.<br/>Create a new account <a href="user">here</a>.</h4>
	</div>
</body>
</html>