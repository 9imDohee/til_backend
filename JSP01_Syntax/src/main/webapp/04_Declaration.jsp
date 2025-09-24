<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 스크립틀릿과 선언 태그 비교</title>
 <style>
        body {
            font-family: 'Malgun Gothic', sans-serif;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #cccccc;
            padding: 12px;
            text-align: left;
        }
        thead th {
            background-color: #e9ecef;
            font-weight: bold;
        }
        tbody tr:nth-child(even) {
            background-color: #f8f9fa;
        }
        td code {
            background-color: #e0e0e0;
            padding: 2px 5px;
            border-radius: 4px;
            font-family: 'Consolas', monospace;
        }
    </style>
</head>
<body>
<div>
선언부?
<br>
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
	
	 <h3>스크립틀릿 vs. 선언 태그 비교</h3>

    <table>
        <thead>
            <tr>
                <th>구분</th>
                <th>스크립틀릿 <code>&lt;% ... %&gt;</code></th>
                <th>선언 태그 <code>&lt;%! ... %&gt;</code></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><strong>변환 위치</strong></td>
                <td><code>_jspService()</code> <strong>메소드 내부</strong></td>
                <td>서블릿 <strong>클래스 내부</strong> (메소드 밖)</td>
            </tr>
            <tr>
                <td><strong>실행 시점</strong></td>
                <td>매 요청마다 실행</td>
                <td>최초 한 번만 실행 (메모리에 유지)</td>
            </tr>
            <tr>
                <td><strong>변수 종류</strong></td>
                <td><strong>지역 변수</strong> (요청마다 초기화)</td>
                <td><strong>멤버 변수</strong> (모든 요청이 공유)</td>
            </tr>
            <tr>
                <td><strong>메소드 선언</strong></td>
                <td>불가능 (X)</td>
                <td><strong>가능 (O)</strong></td>
            </tr>
            <tr>
                <td><strong>주 사용처</strong></td>
                <td>반복/조건문, 요청 처리 로직</td>
                <td>공용 변수/메소드 정의</td>
            </tr>
        </tbody>
    </table>
	<a href="index.html">홈으로</a>
	
	
</body>
</html>