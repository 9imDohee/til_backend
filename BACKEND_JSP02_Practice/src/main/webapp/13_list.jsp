<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import= "com.ssafy.dto.Person %>
<%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	//List<Person> pList = request.getAttribute("pList");
	%>
	
	for(Person p:pList){
	 	out.println(p.toString()+"<br>")
	 }

</body>
</html>