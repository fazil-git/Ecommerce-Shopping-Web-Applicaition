<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Shop 1</title>
</head>
<body>
	<br><br><br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<button type="submit" class="btn btn-danger float-right"><jsp:include page="logout.jsp"></jsp:include></button>
				<br>
				<h4>Mobile Shop</h4>
				<br>
				<form action="shop.do">
					<c:forEach var="item" items="${itemsInShop }" >
						<input type="hidden" name="formid" value="shopping">
						<input type="hidden" name="shopid" value="shop1">
						<fieldset>
							<input type="checkbox" name="${item.itemId }" value="${item.itemDescription }">${item.itemDescription }<p>
						</fieldset>
					</c:forEach>		
					<button type="submit" class="btn btn-success">Nextshop</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>