package com.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MainServlet
 * url이 /main으로 들어왔을 때, 쿼리 스트링으로 함께 들어온 dan 값을 사용해 구구단을 출력하는 서블릿
 */
@WebServlet("/main") //url 매핑 
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// get 요청 처리
	// url .../main?dan=7
	// doGet 메소드는 서블릿 컨테이너 (톰캣)으로부터 2개의 객체를 자동으로 전달받음
	// 1. HttpServeletRequest req : 요청 정보 
	// 2. HttpServletResponse resp: 응답을 만들 도구
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();// 이 코드의 실행으로 서버와 클라이언트 사이에 텍스트를 보낼 수 있는 통로(stream)가 열림
		int dan = Integer.parseInt(req.getParameter("dan")); // dan이라는 이름의 파라미터 값을 문자열 -> 정수 변환
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>구구단</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<h1>구구단</h1>");
		for (int i = 1; i <= 9; i++) {
			writer.printf("%d * %d = %d<br>", dan, i, dan * i);
		}
		writer.append("</body>");
		writer.append("</html>");

	}

}
