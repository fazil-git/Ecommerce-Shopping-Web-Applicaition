<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<br>
	<div class="container col-md-5">
	<h1>Welcome to Amazon shopping site...</h1>
		<br>
		<div class="card">
			<div class="card-body">
				<button type="submit" class="btn btn-info"><jsp:include page="ecart.jsp"></jsp:include></button>
				<button type="submit" class="btn btn-danger float-right"><jsp:include page="logout.jsp"></jsp:include></button>
				<br><br>
				<h4>Welcome <%=session.getAttribute("uname") %>,</h4>
				<br><br><br>
				<form action="shop.do">
					<input type="hidden" name="formid" value="shopping">
					<input type="hidden" name="shopid" value="first">
					<button type="submit" class="btn btn-success">Do shopping...</button>
				</form>
			</div>
		</div>
	</div>
	
	
	
	
</body>
</html>