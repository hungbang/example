<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- sử dụng jstl để import đường dẫn css vào file . Nhưng có thể đến đây nó chưa chạy. run test now. -->
<link rel="stylesheet" href='<c:url value="/static/css/style.css" />'>


<title>${ requestScope.param }</title>
</head>
<body>

	<div id="headerContent">
		<a href="loginfilter.jsp">Demo Filter</a> | <a href="upload.jsp">Upload Demo</a>
	</div>
	
	<h1>This is demo</h1>
	
	<form action="LoginServlet" method="post">
		<input id="inputcss" name="name" value="" />
		<input id="inputcss" name="address" value="" />
		<input id="btncss" type="submit" value="Submit" />
	</form>
	
</body>
</html>