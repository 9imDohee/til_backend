<!-- Directive: imformative tag -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주석문</title>
</head>
<body>
	<body>
	<div>3가지 주석의 차이점: </div>
	<div>1. HTML 주석 <!--   --></div>
	<div>서버에서 아무런 처리 없이 그대로 클라이언트에게 전송됨
	최종적으로 생성된 HTML 코드에 포함되므로, 사용자가 브라우저에서 페이지 소스 보기를 하면 내용이 그대로 보임</div>
	<div> 주로 HTML의 특정 부분을 설명할 때 사용하지만, 중요한 정보를 담아서는 안 됨</div>
	
	<div>2. JSP 주석 <%-- --%> </div>
	<div>자바 코드로 변환되지도 않고, 클라이언트에게 전송되지도 않음, 페이지 소스 보기에도 보이지 않음</div>
	<div>JSP 코드 자체에 대한 설명을 남길때나 특정 JSP 코드 블록을 잠시 비활성화할 때 사용, 가장 안전한 서버 측 주석</div>
	
	<div>3. 자바 주석 //  /* */</div>
	<div>스크립틀릿 <%  %>안에서 사용되는 일반적인 자바 주석으로 JSP가 서블릿으로 변환될 때, 이 주석은 자바 코드의 주석으로 그대로 옮겨짐</div>
	<div>스크립틀릿 내부의 복잡한 자바 로직을 설명할 때 사용됨</div>
	</body>
	
	<!-- 이것은 HTML 주석입니다. (클라이언트에게 노출이 됩니다.)-->
	<%-- 이것은 JSP 주석입니다.  (클라이언트에게 노출이 되지 않습니다.): java 파일로도 안 바뀜 --%>
	<%
	//이것은 클라이언트에게 노출이 될까요?
	%>
	 <h1>JSP에서 사용하는 주석의 차이점</h1>

    <table>
        <thead>
            <tr>
                <th>구분</th>
                <th>HTML 주석</th>
                <th>JSP 주석</th>
                <th>자바 주석 (스크립틀릿)</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><strong>형식</strong></td>
                <td><code>&lt;!-- ... --&gt;</code></td>
                <td><code>&lt;%-- ... --%&gt;</code></td>
                <td><code>&lt;% //... %&gt;</code> 또는 <code>&lt;% /*...*/ %&gt;</code></td>
            </tr>
            <tr>
                <td><strong>처리 위치</strong></td>
                <td>클라이언트 (브라우저)</td>
                <td>서버</td>
                <td>서버</td>
            </tr>
            <tr>
                <td><strong>소스 코드 노출</strong></td>
                <td>보임 (O)</td>
                <td>보이지 않음 (X)</td>
                <td>보이지 않음 (X)</td>
            </tr>
            <tr>
                <td><strong>.java 변환</strong></td>
                <td>그대로 전달</td>
                <td>제거됨</td>
                <td>자바 주석으로 포함됨</td>
            </tr>
        </tbody>
    </table>
	
	<a href="index.html">홈으로</a>
</body>
</html>