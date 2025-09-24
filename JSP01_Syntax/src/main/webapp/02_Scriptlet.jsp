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
	<div>스크립트릿?</div>
	<div>HTML 코드 안에 프로그래밍 언어(주로 Java, JSP 등)의 스크립트 코드를 삽입해서 실행할 수 있게
		하는 구문</div>

	<br>
	<div>JSP의 내장객체</div>
	<div>JSP에서는 개발의 편의성을 위해 미리 만들어진 9개의 내장 객체를 제공</div>
	<div>out은 그 중 하나, JspWriter 타입의 객체로, JSP 컨테이너가 미리 만들어서 out이라는 이름으로 제공해줌</div>
	<div>out.print()로 바로 가져다 사용하면 됨</div>
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
