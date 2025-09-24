<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
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

	<h2>서블릿의 생명주기 & 싱글턴 패턴</h2>
	<div>서블릿 컨테이너(톰캣)은 기본적으로 하나의 서블릿에 의해 인스턴스를 딱 하나만 생성한다.</div>
	<p>그리고 그 하나의 인스턴스가 모든 사용자의 요청을 처리</p>
	<p>이것이 싱글턴 패턴과 유사하게 동작</p>

	<h2>변수의 생명주기</h2>
	<h3>선언태그-> 멤버 변수</h3>
	<div>
		생명주기 <br> 서블릿 인스턴스가 처음 생성될 때 : count1이 0일 때 서버가 종료되거나 서블릿이 메모리에서
		사라질때까지
	</div>

	<div>
		싱글턴과의 관계<br> 주방장이 1명인 싱클턴 패턴과 유사, 새로고침할 때마다 count1의 값이 계속해서 증가함
		싱글턴 인스턴스의 멤버 이므로 모든 요청이 공유됨
	</div>
	<a href="index.html">홈으로</a>

	<h3>스크립틀릿-> 지역 변수</h3>
	<div>
		생명주기 <br> 새로운 요청이 들어올 때마다 새롭게 생성됨 <br>
		요청에 대한 응답이 끝나면 바로 종료됨
	</div>

	<div>
		싱글턴과의 관계<br> 새로고침할 때마다 count2는 항상 0으로, 1이된 후 버려지므로, 화면에는 1만 보임
		싱글턴 인스턴스의 메소드 내 지역변수이므로 요청마다 독립적임
		
	</div>
	<a href="index.html">홈으로</a>
</body>
</html>

