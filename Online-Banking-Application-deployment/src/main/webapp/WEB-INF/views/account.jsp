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
<title>Account Management</title>
</head>
<body>
	<sec:authorize
		access="hasAuthority('Administrator') || hasAuthority('Manager')">
		<div class="container p-3 my-3 bg-dark text-white" align="center">
			<h1>Account Management</h1>
			<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="account">My
							Account</a></li>
					<li class="nav-item"><a class="nav-link" href="customer">Customer</a></li>
					<li class="nav-item"><a class="nav-link" href="branch">Branches</a></li>
					<li class="nav-item"><a class="nav-link" href="role">Role</a></li>
					<li class="nav-item"><a class="nav-link" href="transactions">Transactions</a></li>
					<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
			<frm:form action="saveAccount" method="POST" modelAttribute="account">
				<table>
					<tr>
						<td>Account ID:</td>
						<td><frm:input path="accountId" /></td>
						<td><frm:errors path="accountId" cssStyle="color:red"/></td>
					</tr>
					<tr>
						<td>Account Branch:</td>
						<td><frm:input path="accountBranch" /></td>
						<td><frm:errors path="accountBranch" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Account Type:</td>
						<td><frm:select name="accountType" path="accountType">
								<frm:option value="" lable="Please select a value"></frm:option>
								<frm:options items="${accountType.values}" />
							</frm:select></td>
						<td><frm:errors path="accountType" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Account Holder:</td>
						<td><frm:input path="accountHolder" /></td>
						<td><frm:errors path="accountHolder" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Account Date Opened:</td>
						<td><frm:input type="date" path="accountDateOpened" /></td>
						<td><frm:errors path="accountDateOpened" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Account Current Balance:</td>
						<td><frm:input type="number" path="accountCurrentBalance" /></td>
						<td><frm:errors path="accountCurrentBalance"
								cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Customer ID:</td>
						<td><frm:input path="accountCustomer" /></td>
						<td><frm:errors path="accountCustomer" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							value="Create Account" class="btn btn-danger"/></td>
					</tr>
				</table>
			</frm:form>
		</div>
		<div class="container p-3">
			<h3>All Accounts</h3>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th align="center">Account ID</th>
						<th align="center">Account Branch</th>
						<th align="center">Account Type</th>
						<th align="center">Account Holder</th>
						<th align="center">Account Date Opened</th>
						<th align="center">Account Current Balance</th>
						<th align="center">Account Customer</th>
					</tr>
				</thead>
				<c:forEach items="${accounts}" var="a">
					<tr>
						<td align="center">${a.accountId}</td>
						<td align="center">${a.accountBranch.branchName}</td>
						<td align="center">${a.accountType}</td>
						<td align="center">${a.accountHolder}</td>
						<td align="center">${a.accountDateOpened}</td>
						<td align="center">${a.accountCurrentBalance}</td>
						<td align="center">${a.accountCustomer.customerName}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</sec:authorize>
	<sec:authorize access="hasAuthority('User')">
	<div class="container p-3 my-3 bg-dark text-white" align="center">
		<h1>My Account</h1>
		<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="account">My
						Account</a></li>
				<li class="nav-item"><a class="nav-link" href="branch">Branches</a></li>
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
		<h3>Your Accounts</h3>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th align="center">Account ID</th>
					<th align="center">Account Branch</th>
					<th align="center">Account Type</th>
					<th align="center">Account Holder</th>
					<th align="center">Account Date Opened</th>
					<th align="center">Account Current Balance</th>
					<th align="center">Account Customer</th>
				</tr>
			</thead>
			<c:forEach items="${yourAccounts}" var="ya">
				<tr>
					<td align="center">${ya.accountId}</td>
					<td align="center">${ya.accountBranch.branchName}</td>
					<td align="center">${ya.accountType}</td>
					<td align="center">${ya.accountHolder}</td>
					<td align="center">${ya.accountDateOpened}</td>
					<td align="center">${ya.accountCurrentBalance}</td>
					<td align="center">${ya.accountCustomer.customerName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
			<frm:form action="saveAccount" method="POST" modelAttribute="account">
				<table>
					<tr>
						<td>Account ID:</td>
						<td><frm:input path="accountId" /></td>
						<td><frm:errors path="accountId" cssStyle="color:red"/></td>
					</tr>
					<tr>
						<td>Account Branch:</td>
						<td><frm:input path="accountBranch" /></td>
						<td><frm:errors path="accountBranch" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Account Type:</td>
						<td><frm:select name="accountType" path="accountType">
								<frm:option value="" lable="Please select a value"></frm:option>
								<frm:options items="${accountType.values}" />
							</frm:select></td>
						<td><frm:errors path="accountType" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Account Holder:</td>
						<td><frm:input path="accountHolder" /></td>
						<td><frm:errors path="accountHolder" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Account Date Opened:</td>
						<td><frm:input type="date" path="accountDateOpened" /></td>
						<td><frm:errors path="accountDateOpened" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Account Current Balance:</td>
						<td><frm:input type="number" path="accountCurrentBalance" /></td>
						<td><frm:errors path="accountCurrentBalance"
								cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Customer ID:</td>
						<td><frm:input path="accountCustomer" /></td>
						<td><frm:errors path="accountCustomer" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							value="Create Account" class="btn btn-danger"/></td>
					</tr>
				</table>
			</frm:form>
		</div>
	</sec:authorize>
</body>
</html>