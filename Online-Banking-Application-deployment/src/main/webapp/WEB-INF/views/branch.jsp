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
<title>Branch Management</title>
</head>
<body>
	<sec:authorize access="hasAuthority('Administrator') || hasAuthority('Manager')">
		<div class="container p-3 my-3 bg-dark text-white" align="center">
			<h1>Account Management</h1>
			<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="account">My
							Account</a></li>
					<li class="nav-item"><a class="nav-link" href="customer">Customer</a></li>
					<li class="nav-item active"><a class="nav-link" href="branch">Branches</a></li>
					<li class="nav-item"><a class="nav-link" href="role">Role</a></li>
					<li class="nav-item"><a class="nav-link" href="transactions">Transactions</a></li>
					<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
			<frm:form action="saveBranch" method="POST" modelAttribute="branch">
			<table>
				<tr>
					<td>Branch ID:</td>
					<td><frm:input path="branchId" /></td>
					<td><frm:errors path="branchId" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Branch Name:</td>
					<td><frm:input path="branchName" /></td>
					<td><frm:errors path="branchName" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Address Line 1:</td>
					<td><frm:input path="branchAddress.addressLine1" /></td>
					<td><frm:errors path="branchAddress.addressLine1" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Address Line 2:</td>
					<td><frm:input path="branchAddress.addressLine2" /></td>
					<td><frm:errors path="branchAddress.addressLine2" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><frm:input path="branchAddress.city" /></td>
					<td><frm:errors path="branchAddress.city" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><frm:input path="branchAddress.state" /></td>
					<td><frm:errors path="branchAddress.state" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td colspan="2" ><input type="submit"
						value="Create" class="btn btn-danger"/></td>
				</tr>
			</table>
		</frm:form>
		<h3>Existing Branches</h3>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th align="center">Branch ID</th>
					<th align="center">Branch Name</th>
					<th align="center">Address Line 1</th>
					<th align="center">Address Line 2</th>
					<th align="center">City</th>
					<th align="center">State</th>
					<th align="center" colspan="2">Action</th>
				</tr>
			</thead>
			<c:forEach items="${branches}" var="b">
				<tr>
					<td align="center">${b.branchId }</td>
					<td align="center">${b.branchName}</td>
					<td align="center">${b.branchAddress.addressLine1}</td>
					<td align="center">${b.branchAddress.addressLine2}</td>
					<td align="center">${b.branchAddress.city}</td>
					<td align="center">${b.branchAddress.state}</td>
					<td align="center"><a href="deleteBranch?id=${b.branchId}">Delete</a></td>
					<td align="center"><a href="updateBranch?id=${b.branchId}">Update</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</sec:authorize>
	<sec:authorize access="hasAuthority('User')">
	<div class="container p-3 my-3 bg-dark text-white" align="center">
		<h1>Branch Management</h1>
		<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="account">My
						Account</a></li>
				<li class="nav-item active"><a class="nav-link" href="branch">Branches</a></li>
				<li class="nav-item"><a class="nav-link" href="customer">Customer</a></li>
				<li class="nav-item"><a class="nav-link" href="transactions">Transactions</a></li>
				<li class="nav-item"><a class="nav-link" href="withdraw">Withdraw</a></li>
				<li class="nav-item"><a class="nav-link" href="deposit">Deposit</a></li>
				<li class="nav-item"><a class="nav-link" href="transfer">Transfer</a></li>
				<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
			</ul>
		</nav>
	</div>
	<div class="container">
		<h3>Available Branches</h3>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th align="center">Branch ID</th>
					<th align="center">Branch Name</th>
					<th align="center">Address Line 1</th>
					<th align="center">Address Line 2</th>
					<th align="center">City</th>
					<th align="center">State</th>
				</tr>
			</thead>
			<c:forEach items="${branches}" var="b">
				<tr>
					<td align="center">${b.branchId }</td>
					<td align="center">${b.branchName}</td>
					<td align="center">${b.branchAddress.addressLine1}</td>
					<td align="center">${b.branchAddress.addressLine2}</td>
					<td align="center">${b.branchAddress.city}</td>
					<td align="center">${b.branchAddress.state}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</sec:authorize>
</body>
</html>