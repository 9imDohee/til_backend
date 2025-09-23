<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부</title>
</head>
<body>
<div>
선언부?
JSP에서 멤버 변수나 메서드를 정의할 때 사용하는 영역
선언부는 JSP 페이지 클래스의 멤버로 들어감
</div>
	<%!int C = 10;

	// 함수 작성 가능
	int add(int A, int B) {
		return A + B;
	}%>
	<%int D = 10;
	//함수 작성 불가능 (서비스 메서드 안에 정의되는 지역 변수)%>
	<a href="index.html">홈으로</a>
</body>
</html>