<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login">
		<pre>
			Email   : <input type = "text" name = "email">
			
			Password: <input type = "password" name = "password">
			
			<input type="submit" value = "login">
			
			<a href="Register.jsp">Sign IN</a>
			
			${msg}
		</pre>
	</form>

</body>
</html>