<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!int A = 20;
	int B = -20;
	String name = "name";

	int abs(int a) {
		return a > 0 ? a : -a;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식</title>a 
	<div>표현식? 변수의 값이나 계산식 혹은 함수를 호출한 결과를 문자열 형태로 웹문서에 출력</div>

	<%
	out.print(name);
	%>
	<%=name%>
	<%=A + B%>
	<%=abs(B)%>
	<a href="index.html">홈으로</a>
</body>
</html>