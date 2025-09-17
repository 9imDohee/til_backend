package com.ssafy.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		int dan = Integer.parseInt(req.getParameter("dan"));
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
