// WEN-INF > web.xml 매핑
package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;characterset=UTF-8");
		PrintWriter writer = response.getWriter();

		// Java 15 버전에 나온 Block String
		writer.write("""
				<html>
				  <head><title>Hello! SSAFY!</title></head>
				  <body>
				    <h1>Hello! Servlet2!</h1>
				  </body>
				</html>
				""");

	}

}
