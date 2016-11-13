<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload page </title>
</head>
<body>
	<div>
		<h3>Choose File to Upload in Server</h3>
		<form action="uploadServlet" enctype="multipart/form-data" method="post">
			<input type="text" name="onlyName" value='' />
			<input type="text" name="onlyName1" value='' />
			<input type="text" name="onlyName2" value='' />
			<input type="file" name="file" />
			<input type="submit" value="Upload Now"/>		
		</form>
	</div>
</body>
</html>