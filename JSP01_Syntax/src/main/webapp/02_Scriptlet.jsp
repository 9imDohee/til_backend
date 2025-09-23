<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿</title>
</head>
<body>
	<h2>스크립트릿 연습</h2>
<body>
	<div> 
	스크립트릿? HTML 코드 안에 프로그래밍 언어(주로 Java, JSP 등)의 스크립트 코드를 삽입해서 실행할 수 있게
		하는 구문</div>

</body>
<br>
<%
int A = 10;
int B = 20;
int sum = A + B;
out.print(A + "+" + B + "=" + sum);
%>
<br>
<a href="index.html">홈으로</a>


</body>
</html>
