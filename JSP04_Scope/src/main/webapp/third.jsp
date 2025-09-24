<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세번째 페이지</title>
</head>
<body>
    <h1>세번째 페이지</h1>
    
    
    <%--
    	Q. 페이지, 요청, 세션, 애플리케이션 속성을 출력
		1. page: 새로운 페이지 -> null
		2. request: 새로운 요청이므로 이전 request에 저장된 데이터는 소멸 -> null
		3. session: 브라우저가 종료되지 않았으므로 그대로 유지
		4. application: 서버가 종료되지 않았으므로 그대로 유지

    --%>
	<p>페이지 속성 : <%= pageContext.getAttribute("name") %></p>
	<p>요청 속성 : <%= request.getAttribute("name") %></p>
	<p>세션 속성 : <%= session.getAttribute("name") %></p>
	<p>애플리케이션 속성 : <%= application.getAttribute("name") %></p>
	
	
</body>
</html>