<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두번째 페이지</title>
</head>
<body>
    <h1>두번째 페이지</h1>
    
    
    <%--
    	1. page
    	index.jsp의 pageContect가 소멸했기 때문에 null
    	
    	2. request
    	request 객체가 그대로 전달됨 -> request data
    	
    	3. session 유효 -> session data
    	
    	4. application 유효 -> application data
    --%>
	<p>페이지 속성 : <%= pageContext.getAttribute("name") %></p>
	<p>요청 속성 : <%= request.getAttribute("name") %></p>
	<p>세션 속성 : <%= session.getAttribute("name") %></p>
	<p>애플리케이션 속성 : <%= application.getAttribute("name") %></p>
	
	
	<%-- 세번째 페이지로 이동하는 링크를 사용함으로써 요청 속성이 유지되는지 확인
	second.jsp -> third.jsp 이동하는 방식이 forward가 아닌 a 태그 링크
	second.jsp에서 a 태그를 통해 페이지를 이동하면
	브라우저가 서버로 새로운 요청을 보내는 것과 같음
	
	따라서 이전 요청 객체는 소멸되고 새로운 요청 객체가 생성됨
	Redirect (a태그) // second.jsp -> third.jsp
	 --%>
	<a href="third.jsp">세번째 페이지로 이동</a>
	
	
</body>
</html>