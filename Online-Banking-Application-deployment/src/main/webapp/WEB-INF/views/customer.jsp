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
<title>Customer Management</title>
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
					<li class="nav-item active"><a class="nav-link" href="customer">Customer</a></li>
					<li class="nav-item"><a class="nav-link" href="branch">Branches</a></li>
					<li class="nav-item"><a class="nav-link" href="role">Role</a></li>
					<li class="nav-item"><a class="nav-link" href="transactions">Transactions</a></li>
					<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
			<h3>All Customers</h3>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th align="center">Customer ID</th>
						<th align="center">Customer's Name</th>
						<th align="center">Gender</th>
						<th align="center">Customer's Date of Birth</th>
						<th align="center">Mobile Nr.</th>
						<th align="center">Phone</th>
						<th align="center">Email</th>
						<th align="center">Address Line 1</th>
						<th align="center">Address Line 2</th>
						<th align="center">City</th>
						<th align="center">State</th>
						<th align="center">SSN</th>
						<th align="center">User ID</th>
					</tr>
				</thead>
				<c:forEach items="${customers}" var="cs">
					<tr>
						<td align="center">${cs.customerId}</td>
						<td align="center">${cs.customerName}</td>
						<td align="center">${cs.customerGender}</td>
						<td align="center">${cs.customerDob}</td>
						<td align="center">${cs.customerMobileNo}</td>
						<td align="center">${cs.customerPhone}</td>
						<td align="center">${cs.customerEmail}</td>
						<td align="center">${cs.customerAddress.addressLine1}</td>
						<td align="center">${cs.customerAddress.addressLine2}</td>
						<td align="center">${cs.customerAddress.city}</td>
						<td align="center">${cs.customerAddress.state}</td>
						<td align="center">${cs.ssn}</td>
						<td align="center">${cs.user.userId}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</sec:authorize>
	<sec:authorize access="hasAuthority('User')">
	<div class="container p-3 my-3 bg-dark text-white" align="center">
		<h1>Customer Management</h1>
		<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="account">My
						Account</a></li>
				<li class="nav-item"><a class="nav-link" href="branch">Branches</a></li>
				<li class="nav-item active"><a class="nav-link" href="customer">Customer</a></li>
				<li class="nav-item"><a class="nav-link" href="transactions">Transactions</a></li>
				<li class="nav-item"><a class="nav-link" href="withdraw">Withdraw</a></li>
				<li class="nav-item"><a class="nav-link" href="deposit">Deposit</a></li>
				<li class="nav-item"><a class="nav-link" href="transfer">Transfer</a></li>
				<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
			</ul>
		</nav>
	</div>
	<div align="center">
		<frm:form action="saveCustomer" method="POST"
			modelAttribute="customer">
			<table>
				<tr>
					<td>Customer ID:</td>
					<td><frm:input path="customerId" /></td>
					<td><frm:errors path="customerId" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Full Name:</td>
					<td><frm:input path="customerName" /></td>
					<td><frm:errors path="customerName" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><frm:radiobutton name="customerGender"
							path="customerGender" value="Male" label="Male" /> <frm:radiobutton
							name="customerGender" path="customerGender" value="Female"
							label="Female" />
					</td>
					<td><frm:errors path="customerGender" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><frm:input type="date" path="customerDob" /></td>
					<td><frm:errors path="customerDob" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Mobile Number:</td>
					<td><frm:input path="customerMobileNo" /></td>
					<td><frm:errors path="customerMobileNo" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><frm:input path="customerPhone" /></td>
					<td><frm:errors path="customerPhone" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><frm:input path="customerEmail" /></td>
					<td><frm:errors path="customerEmail" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Address Line 1:</td>
					<td><frm:input path="customerAddress.addressLine1" /></td>
					<td><frm:errors path="customerAddress.addressLine1" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Address Line 2:</td>
					<td><frm:input path="customerAddress.addressLine2" /></td>
					<td><frm:errors path="customerAddress.addressLine2" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><frm:input path="customerAddress.city" /></td>
					<td><frm:errors path="customerAddress.city" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><frm:input path="customerAddress.state" /></td>
					<td><frm:errors path="customerAddress.state" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>SSN:</td>
					<td><frm:input path="ssn" /></td>
					<td><frm:errors path="ssn" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>User ID:</td>
					<td><frm:input path="user.userId" /></td>
					<td><frm:errors path="user.userId" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td><input type="submit"
						value="Create" class="btn btn-danger"/></td>
					<td><a href="login" class="btn btn-danger">Login</a></td>
				</tr>
			</table>
		</frm:form>
	</div>
	</sec:authorize>
</body>
</html>