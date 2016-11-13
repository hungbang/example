<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input information to Login</title>

<style type="text/css">
input {
	
}

body {
	text-align: center;
	background-color: rgb(33, 140, 109);
}

form {
	margin: 50px !important;
}

#btnSubmit {
	text-transform: uppercase;
	font-weight: bold;
}
</style>

</head>

<body>
	<div>
		<form method="post" action="LoginServlet">
			<input name="username" value="" id="username" /> <input
				name="password" value="" id="password" /> <select name="role">
				<option value="admin">Admin</option>
				<option value="user">User</option>
			</select> <input type="submit" value="Log In" id="btnSubmit" />
		</form>
	</div>
</body>
</html>