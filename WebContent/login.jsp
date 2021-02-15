<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<jsp:useBean id="lang" class="bean.LoginLangBean">
		<jsp:setProperty name="lang" property="resource" value="${rb }" />
	</jsp:useBean>
	<br><br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="login.do">
				<input type="hidden" name="formid" value="login">
					<fieldset class="form-group">
						<label><jsp:getProperty property="username" name="lang"/>:</label>
						<input type="text" name="uname">
					</fieldset>
					<fieldset class="form-group">
						<label><jsp:getProperty property="password" name="lang"/>:</label>
						<input type="text" name="upass"><p>
					</fieldset>
					<button type="submit" class="btn btn-success">${lang.submit }</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>