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
<title>Withdraw</title>
</head>
<body>
	<sec:authorize access="hasAuthority('User')">
	<div class="container p-3 my-3 bg-dark text-white" align="center">
		<h1>Withdraw Money</h1>
		<nav class="navbar navbar-expand-sm bg-danger navbar-light justify-content-center">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="account">My Account</a></li>
				<li class="nav-item"><a class="nav-link" href="branch">Branches</a></li>
				<li class="nav-item"><a class="nav-link" href="customer">Customer</a></li>
				<li class="nav-item"><a class="nav-link" href="transactions">Transactions</a></li>
				<li class="nav-item active"><a class="nav-link" href="withdraw">Withdraw</a></li>
				<li class="nav-item"><a class="nav-link" href="deposit">Deposit</a></li>
				<li class="nav-item"><a class="nav-link" href="transfer">Transfer</a></li>
				<li class="nav-item"><a class="nav-link" href="login?logout">Logout</a></li>
			</ul>
		</nav>
	</div>
	<div align="center">
		<frm:form action="makeWithdrawal" method="POST" modelAttribute="bankTransaction" name="bankTransactionForm">
			<table>
				<tr>
					<td>Enter Your Account ID:</td>
					<td><frm:input name="trxFromAccount" path="trxFromAccount" /></td>
				</tr>
				<tr>
					<td>Amount:</td>
					<td><frm:input type="number" path="trxAmount" /></td>
				</tr>
				<tr>
					<td>Transaction Type:</td>
					<td>
						<frm:select  name="transactionType" path="transactionType"  >	
							<frm:option value="" lable="Please select a value" ></frm:option>
	    					<frm:options items="${transactionType.values}" />
						</frm:select>
					</td>
				</tr>
				<tr>
					<td>Date:</td>
					<td><frm:input type="date" path="trxLocalDateTime" /></td>
				</tr>
				<tr>
					<td>Comments:</td>
					<td><frm:input type="text" path="comments" /></td>
				</tr>
				<tr>
					<td colspan="2" ><input type="submit"
						value="Withdraw" class="btn btn-danger"/></td>
				</tr>
			</table>
		</frm:form>
	</div>
	</sec:authorize>
</body>
</html>