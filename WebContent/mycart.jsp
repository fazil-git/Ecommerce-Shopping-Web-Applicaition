<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
</head>
<body>
	<div class="row">
		<div class="container">
			<button type="submit" class="btn btn-danger float-right"><jsp:include page="logout.jsp"></jsp:include></button>
			<h3 class="text-center">Your cart</h3>
			<hr>
			<br>
			<table class="table table-bordered table-striped text-center">
				<thead>
					<tr>
						<th>itemdescription</th>
						<th>Shopname</th>
						<th>Qty</th>
						<th>price</th>
						<th>cost</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="item" items="${MyItems}">

						<tr>
							<td><c:out value="${item.itemdescription}"/></td>
							<td><c:out value="${item.shopname}"/></td>
							<td><c:out value="${item.numberOfUnit}"/></td>
							<td><c:out value="${item.price}"/></td>
							<td><c:out value="${item.cost}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form action="place.do">
				<input type="hidden" name="formid" value="place.order">
				<input type="submit" value="Place Order"> Click here place your order!
			</form>
		</div>
	</div>

</body>
</html>