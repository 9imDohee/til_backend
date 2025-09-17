package com.ssafy.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletParameter2
 */
@WebServlet("/ServletParameter2")
public class ServletParameter2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = request.getParameter("text");
		int num = Integer.parseInt(request.getParameter("number"));
		String campus = request.getParameter("campus");
		String[] fruits = request.getParameterValues("fruit");
		String progrmmingLanguage = request.getParameter("programming-language");
		String content = request.getParameter("content");
		String hidden = request.getParameter("action");

		System.out.println(text);
		System.out.println(num);
		System.out.println(campus);
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
		System.out.println(progrmmingLanguage);
		System.out.println(content);
		System.out.println(hidden);
	}
}
