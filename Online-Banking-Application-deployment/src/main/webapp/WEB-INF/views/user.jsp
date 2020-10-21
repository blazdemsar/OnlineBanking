<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>
	<div class="container p-3 my-3 bg-dark text-white" align="center">
		<h1>Create A New Account</h1>
		<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
			</ul>
		</nav>
	</div>
	<div class="container">
		<h2>Create An Account Below</h2>
		<frm:form action="saveUser" method="POST" modelAttribute="user"
			name="userForm">
			<table>
				<tr>
					<td>User Id:</td>
					<td><frm:input name="userId" path="userId" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><frm:input path="name" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><frm:input type="password" path="password" /></td>
				</tr>


				<tr>
					<td>Email:</td>
					<td><frm:input path="email" /></td>
				</tr>
				<tr>
					<td>Roles:</td>
					<td><c:forEach items="${roleSet}" var="role">
							<c:choose>
								<c:when test="${fn:contains(selectedRoles, role)}">
									<strong>${role.name}</strong>
									<frm:checkbox path="roles" value="${role.roleId}"
										checked="true" />&nbsp;&nbsp;
										</c:when>
								<c:otherwise>
											${role.name}<frm:checkbox path="roles" value="${role.roleId}" />&nbsp;&nbsp;
										</c:otherwise>
							</c:choose>
						</c:forEach></td>
				</tr>
				<tr>
					<td><input type="submit"
						value="Create" class="btn btn-danger" /></td>
					<td><a href="customer" class="btn btn-danger">Next</a></td>
				</tr>
			</table>
		</frm:form>
	</div>
	<sec:authorize
		access="hasAuthority('Administrator') || hasAuthority('Manager')">
		<div class="container">
			<c:if test="${not empty users}">
			<hr />
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th align="center">User Id</th>
						<th align="center">Name</th>
						<th align="center">Password</th>
						<th align="center">Email</th>
						<th align="center">Roles</th>
						<th align="center" colspan="2">Action</th>
					</tr>
				</thead>
				<c:forEach items="${users}" var="user">
					<tbody>
						<tr>
							<td align="center">${user.userId}</td>
							<td align="center">${user.name}</td>
							<td align="center">${user.password}</td>
							<td align="center">${user.email}</td>
							<td align="center"><c:forEach items="${user.roles}" var="role">
   							${role.name}&nbsp;
				</c:forEach></td>
							<td align="center"><a
								href="${pageContext.request.contextPath}/deleteUser?userId=${user.userId}">Delete</a>
								&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath}/updateUser?userId=${user.userId}">Update</a>
							</td>
						</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
		</div>
	</sec:authorize>
</body>
</html>