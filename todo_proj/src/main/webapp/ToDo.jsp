<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="submit">
		<pre>
			ToDo Title:
			<input type="text" name="title">
			ToDo Description:
			<input type="text" name = "description">
			Status:
			In Progress<input type="Radio" value = "In Progress" name = "status">Done<input type="Radio" value = "Done" name = "status">
			ToDo Target Date:
			<input type="date" name = "date">
			<input type="submit" value="Save">
		</pre>
	</form>
</body>
</html>