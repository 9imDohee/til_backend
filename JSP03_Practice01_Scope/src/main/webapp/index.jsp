<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
<!--
	* 내장 객체의 스코프
	'name'이라는 동일한 이름의 변수에 서로 다른 값을 담아 4개의 서로 다른 유효 범위를 가진 저장소에 저장
	-> 각 데이터가 언제까지 살아남고, 어디까지 전달되는지 확인하기
	
	1. page scope (pageContext)
	- 생존 기간: 오직 현재 JSP 페이지 안에서만 유효, 페이지 실행이 시작될 때 생성되고, 끝나면 수멸
	- 해당 페이지 안에서만 잠깐 사용할 임시 변수가 필요할 때 사용
	
	2. request scope
	- 생존 기간: 클라이언트의 http 요청이 처리되는 동안 유효
	- 브라우저에서 서버로 요청이 들어올 때 생성되고, 서버가 브라우저에 응답을 완료하면 소멸됨
	- forward 방식으로 페이지가 이동하면, request 객체가 다음 페이지로 그대로 전달됨
	- MVC 패턴에서 컨트롤러 (Servlet)가 생성한 데이터를 뷰(JSP)에 전달할 때 가장 흔하게 사용됨
	
	3. session scope
	- 하나의 브라우저가 접속해 있는 동안 계속 유효함
	- 사용자가 웹 사이트에 처음 접속할 때 생성되고, 브라우저를 닫거나 세션이 만료될 때 소멸됨
	- 로그인 정보, 장바구니처럼 사용자가 사이트를 이요하는 내내 유지되어야 하는 데이터를 저장할 때 사용
	
	4. application scope
	- 웹 애플리케이션(서버)이 시작될 때 생성되어 종료될 때까지 유효
	- 이 데이터는 모든 사용자가 공유
	- 한 사용자가 이 값을 바꾸면 다른 사용자에게도 바뀐 값이 보임
	- 웹 사이트의 전체 방문자 수, 모든 사용자가 공유해야 하는 설정 정보를 저장할 때 사용
	
	[코드 실행 흐름]
	1. 사용자가 브라우저에서 index.jsp 요청
	2. 서버는 page, request, session, application 4개의 저장소에 각각 데이터를 저장
	3. 서버 콘솔에 4개의 데이터가 모두 출력됨
	4. forward 명령을 통해 request, response 객체를 second.jsp로 전달
  -->    
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫번째 페이지</title>
</head>
<body>
	<h1>첫번째 페이지</h1>
	
	<%
		/*
			pageContext : 페이지 단위의 속성
			pageContext는 JSP 페이지에서 사용할 수 있는 객체로서 
			JSP 페이지의 수명 주기와 같이 존재하며, JSP 페이지의 수명 주기와 동일하게 존재함 (JSP 페이지가 소멸되면 소멸)
			페이지 단위 속성에 "name"이라는 이름으로 "pageContext data"라는 값을 저장	
			이 데이터는 index.jsp를 벗어나는 순간 즉시 사라짐
		*/
		pageContext.setAttribute("name", "pageContext data");
	


		/*
			request : 요청 단위의 속성
			request는 클라이언트의 요청 정보를 담고 있는 객체로서 
			클라이언트의 요청이 있을 때마다 생성되어 클라이언트의 요청을 처리하고 응답함 (요청이 종료되면 소멸)
			요청 단위 속성에 "name"이라는 이름으로 "request data"라는 값을 저장
		*/
		request.setAttribute("name", "request data");
		

		
		/*
			session : 세션 단위의 속성
			session은 클라이언트의 세션 정보를 담고 있는 객체로서 
			클라이언트의 세션이 생성되면 생성되어 클라이언트의 세션 정보를 처리하고 응답함 (세션이 종료되면 소멸)
			세션 단위 속성에 "name"이라는 이름으로 "session data"라는 값을 저장
		*/
		session.setAttribute("name", "session data");
		
		
		
		
		/*
			application : 어플리케이션 단위의 속성	
			application은 웹 애플리케이션의 정보를 담고 있는 객체로서 
			웹 애플리케이션이 시작되면 생성되어 웹 애플리케이션의 정보를 처리하고 응답함 (웹 애플리케이션이 종료되면 소멸)
			어플리케이션 단위 속성에 "name"이라는 이름으로 "application data"라는 값을 저장
			웹 사이트의 전체 방문자 수, 모든 사용자가 공유해야 하는 설정 정보 등을 저장할 때 사용
		*/		
		application.setAttribute("name", "application data");
		
		
		System.out.println("first page"); // 서버 기록 확인
		
		System.out.println("페이지 속성 " + pageContext.getAttribute("name"));
		System.out.println("요청 속성 "+ request.getAttribute("name"));
		System.out.println("세션 속성 "+ session.getAttribute("name"));
		System.out.println("어플리케이션 속성 "+ application.getAttribute("name"));
		
		/* forwarding (포워딩) // index.jsp -> second.jsp
		index.jsp가 받은 요청과 응답 객체를 그대로 second.jsp에게 넘겨 작업을 위임하는 방식
		second.jsp로 포워딩 : request, response 객체를 전달하여 second.jsp로 이동
		*/ 
		request.getRequestDispatcher("second.jsp").forward(request, response);
	%>
</body>
</html>