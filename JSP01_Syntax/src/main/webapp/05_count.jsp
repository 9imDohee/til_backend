<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int count1 = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호출</title>
</head>
<body>

	<%
	int count2 = 0;

	out.println("count1: " + (++count1));
	out.println("<br>");
	out.println("count2: " + (++count2));
	%>

	<div>생명주기 & 싱글턴 패턴</div>
	<a href="index.html">홈으로</a>
</body>
</html>

