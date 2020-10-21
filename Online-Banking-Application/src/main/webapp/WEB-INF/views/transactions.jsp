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
<title>Transaction History</title>
</head>
<body>
	<sec:authorize
		access="hasAuthority('Administrator') || hasAuthority('Manager')">
		<div class="container p-3 my-3 bg-dark text-white" align="center">
			<h1>Transaction Management</h1>
			<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="account">My
							Account</a></li>
					<li class="nav-item"><a class="nav-link" href="customer">Customer</a></li>
					<li class="nav-item"><a class="nav-link" href="branch">Branches</a></li>
					<li class="nav-item"><a class="nav-link" href="role">Role</a></li>
					<li class="nav-item active"><a class="nav-link" href="transactions">Transactions</a></li>
					<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
		<h3>All Transactions</h3>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th align="center">Transaction ID</th>
					<th align="center">Sender's Account</th>
					<th align="center">Recepient's Account</th>
					<th align="center">Amount</th>
					<th align="center">Transaction Type</th>
					<th align="center">Date</th>
					<th align="center">Comments</th>
				</tr>
			</thead>
			<c:forEach items="${allTransactions}" var="t">
				<tr>
					<td align="center">${t.trxID}</td>
					<td align="center">${t.trxFromAccount}</td>
					<td align="center">${t.trxToAccount}</td>
					<td align="center">${t.trxAmount}</td>
					<td align="center">${t.transactionType}</td>
					<td align="center">${t.trxLocalDateTime}</td>
					<td align="center">${t.comments}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</sec:authorize>
	<sec:authorize access="hasAuthority('User')">
	<div class="container p-3 my-3 bg-dark text-white" align="center">
		<h1>Transaction History</h1>
		<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="account">My Account</a></li>
				<li class="nav-item"><a class="nav-link" href="branch">Branches</a></li>
				<li class="nav-item"><a class="nav-link" href="customer">Customer</a></li>
				<li class="nav-item"><a class="nav-link" href="user">User</a></li>
				<li class="nav-item active"><a class="nav-link" href="transactions">Transactions</a></li>
				<li class="nav-item"><a class="nav-link" href="withdraw">Withdraw</a></li>
				<li class="nav-item"><a class="nav-link" href="deposit">Deposit</a></li>
				<li class="nav-item"><a class="nav-link" href="transfer">Transfer</a></li>
				<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
			</ul>
		</nav>
	</div>
	<div class="container">
		<h3>Your Transactions</h3>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th align="center">Transaction ID</th>
					<th align="center">Sender's Account</th>
					<th align="center">Recepient's Account</th>
					<th align="center">Amount</th>
					<th align="center">Transaction Type</th>
					<th align="center">Date</th>
					<th align="center">Comments</th>
				</tr>
			</thead>
			<c:forEach items="${yourTransactions}" var="t">
				<tr>
					<td align="center">${t.trxID}</td>
					<td align="center">${t.trxFromAccount}</td>
					<td align="center">${t.trxToAccount}</td>
					<td align="center">${t.trxAmount}</td>
					<td align="center">${t.transactionType}</td>
					<td align="center">${t.trxLocalDateTime}</td>
					<td align="center">${t.comments}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</sec:authorize>
</body>
</html>