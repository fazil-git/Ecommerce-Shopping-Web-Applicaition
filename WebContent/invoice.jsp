<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
</head>
<body>
	<br><br>
	<div class="row">
		<div class="container">
			<button type="submit" class="btn btn-danger float-right"><jsp:include page="logout.jsp"></jsp:include></button>
			<h3 class="text-center">Invoice</h3>
			Bill.No: <h2 class="text-left">${billno }</h2>
			<hr>
			<br>
			<table class="table table-bordered table-striped text-center">
				<thead>
					<tr>
						<th>itemdescription</th>
						<th>Unit</th>
						<th>Qty</th>
						<th>price</th>
						<th>cost</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="item" items="${invoice}">

						<tr>
							<td><c:out value="${item.itemdescription}"/></td>
							<td><c:out value="${item.unit}"/></td>
							<td><c:out value="${item.qty}"/></td>
							<td><c:out value="${item.price}"/></td>
							<td><c:out value="${item.cost}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>	
</body>
</html>