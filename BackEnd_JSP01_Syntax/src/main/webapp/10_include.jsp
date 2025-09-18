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
</body>
</html>