<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "todo" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<todo:form action = "update" modelAttribute="todo">
		
			 <todo:input path="id" type="hidden"/>
			 <todo:input path="title" type="hidden"/>
		 <todo:input path="description" type="hidden"/>
			status      : <todo:input path="status"/>
			<todo:input path="date" type="hidden"/>
			<%-- <todo:input path="reg" type="hidden"/> --%>
			<todo:button>Update</todo:button>
		
	</todo:form>
</body>
</html>