// 어노테이션 임포트

package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet; // @WebServlet 어노테이션 임포트 (서블릿 v.3.0~)
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/my") // 어노테이션으로 이 서블릿을 어떤 url과 매핑할지 결정
public class MyServlet extends HttpServlet{ // extends HttpServlet
	
	private static final long serialVersionUID = 1L;
	
	//doXXXX 한개는 존재해야한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		//Java 15 버전에 나온 Block String
		writer.write("""
		<html>
		  <head><title>Hello! SSAFY!</title></head>
		  <body>
		    <h1>Hello! Servlet1!</h1>
		  </body>
		</html>
		""");

	}

}
