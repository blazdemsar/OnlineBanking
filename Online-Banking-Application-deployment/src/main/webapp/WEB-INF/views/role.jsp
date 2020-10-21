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
<title>Role Management</title>
</head>
<body>
	<sec:authorize
		access="hasAuthority('Administrator') || hasAuthority('Manager')">
		<div class="container p-3 my-3 bg-dark text-white" align="center">
			<h1>Account Management</h1>
			<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="account">My
							Account</a></li>
					<li class="nav-item"><a class="nav-link" href="customer">Customer</a></li>
					<li class="nav-item"><a class="nav-link" href="branch">Branches</a></li>
					<li class="nav-item"><a class="nav-link" href="user">User</a></li>
					<li class="nav-item active"><a class="nav-link" href="role">Role</a></li>
					<li class="nav-item"><a class="nav-link" href="transactions">Transactions</a></li>
					<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
		<h1>Role Management</h1>
		<frm:form action="saveRole" method="POST" modelAttribute="role">
			<table>
				<tr>
					<td>Role ID:</td>
					<td><frm:input path="roleId" /></td>
				</tr>
				<tr>
					<td>Role Name:</td>
					<td><frm:input path="name" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="Submit"
						value="Submit" /></td>
				</tr>
			</table>
		</frm:form>
		<br/>
		<h3>Existing Roles</h3>
		<table>
			<tr>
				<th>Role ID</th>
				<th>Role Name</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach items="${roles}" var="r">
				<tr>
					<td>${r.roleId}</td>
					<td>${r.name}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</sec:authorize>
</body>
</html>