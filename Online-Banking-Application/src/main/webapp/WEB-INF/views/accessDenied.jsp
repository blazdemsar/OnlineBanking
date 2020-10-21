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
<title>Access Denied</title>
</head>
<body>
	<div class="container p-3 my-3 bg-dark text-white" align="center">
		<h1>Oops, looks like you're trying to access a page... without the access.</h1>
		<nav
			class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="user">Register</a></li>
			</ul>
		</nav>
	</div>
	<div class="container">
		<h3>${message}</h3>
		<p>
			Hi ${pageContext.request.userPrincipal.name }, you don't have access
			to this page. <br> Click <a href="/">Home</a> to return to home
			page. </p>
	</div>
</body>
</html>