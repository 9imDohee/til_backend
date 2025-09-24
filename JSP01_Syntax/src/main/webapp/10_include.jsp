<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다른 JSP include</title>
</head>
<body>
<!-- common/... or
 	 /common/... 으로도 작성 가능  -->
<%@ include file="./common/header.jsp" %>
<p> 본문의 내용입니다 블라블라 </p>

<h2>절대 경로</h2>
<div> 맨 앞에 / <br>
웹 애플리케이션의 최상위 폴더 (루트)에서부터 경로를 찾기 시작
파일의 현재 위치와 상관없이 항상 동일한 경로 유지- > 안정적</div>

<h2>상대 경로</h2>
<div>맨 앞에 /가 없음<br>
현재 파일이 있는 위치에서부터 경로를 찾기 시작</div>
</body>
</html>