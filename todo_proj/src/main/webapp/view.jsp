<%@page import="com.org.dto.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "2px solid black">
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Status</th>
			<th>Date</th>
			<th colspan="2">Actions</th>
		</tr>
		
		<%
			List<Todo> todo = (List<Todo>) session.getAttribute("ToDo");
			System.out.println("my list-->"+todo);
			for(Todo td : todo) {
		%>
		<tr>
			<td><%=td.getTitle()%></td>
			<td><%=td.getDescription()%></td>
			<td><%=td.getStatus()%></td>
			<td><%=td.getDate()%></td>
			<td><a href="edit?id=<%=td.getId()%>">Edit</a></td>
			<td><a href="delete?id=<%=td.getId()%>">Delete</td>
		</tr>
		<%}%>
	</table>
	
	${msg}
	
	<a href = "Home.jsp">click to go home</a>
</body>
</html>