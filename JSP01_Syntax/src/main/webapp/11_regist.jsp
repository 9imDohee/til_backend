<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 사용자로부터 입력을 받아 서버로 전송하는 등록 폼 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록</title>
</head>
<body>
	<h3>사람 등록</h3>
	<!-- action: 폼 데이터가 전송될 목적지 URL지정 -->
	<form action="main" method="POST">
		<!-- 사용자 눈에 보이지 않지만, 서버로 데이터를 보낼 때 함께 전송되는 숨겨진 입력 필드 -->
		<input type="hidden" name="action" value="regist"> <label>이름
			: </label> <input type="text" placeholder="이름을 입력하세요" name="name"><br>
		<label>나이 : </label> <input type="number" min="0"
			placeholder="나이를 입력하세요" name="age"><br> <input
			type="radio" id="man" name="gender" value="man"> <label
			for="man">남자</label> <input type="radio" id="woman" name="gender"
			value="woman"> <label for="woman">여자</label>

		<fieldset>
			<legend>취미</legend>
			<input type="checkbox" id="sleep" name="hobby" value="sleep">
			<label for="sleep">수면</label> <input type="checkbox" id="eat"
				name="hobby" value="eat"> <label for="eat">먹기</label> <input
				type="checkbox" id="study" name="hobby" value="study"> <label
				for="study">공부</label>
		</fieldset>
		<input type="submit" value="등록">
	</form>
</body>
</html>
