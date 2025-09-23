package com.ssafy.dto;

import java.io.IOException;
import java.util.List;

import com.ssafy.manager.PersonManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Front-Controller 패턴: 컨텍스트 루트/main 요청이 오면, 이 코드가 동작함
// regist.jsp ---요청통로---> MainServlet(Person 객체 만들기)---포워딩---> result.jsp
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	private PersonManager manager=PersonManager.getManager();

	// CRUD -> 요청 분기? request 객체 (method, context, parameter)
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getMethod()); // POST
		System.out.println(request.getContextPath()); // /BACKEND_JSP02_Practice
		String act = request.getParameter("act");

		switch(act) {

		case "regist":
			doRegist(request,response);
			break; // 꼭!!

		case "list":
			doList(request,response);
			break;
		}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> pList = manager.getList();
		request.setAttribute("pList", pList); // 포워딩
		request.getRequestDispatcher("13_list.jsp").forward(request, response);
		
		
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");

		Person p = new Person(name, age, gender, hobbies);

		manager.add(p);
		
		// 12_result.jsp로 보내는 방법 (1. 포워딩 / 2. 리다이렉팅)
		request.setAttribute("person", p); // person 이름(result.jsp에서 꺼내서 쓸 이름)으로 p 보내기

		// 1.포워딩 (RequestDispatcher: interface, /: 웹 애플리케이션의 루트(context root)를 기준)
		// RequestDispatcher disp = request.getRequestDispatcher("/12_result.jsp");
		// disp.forward(request,response);

		// 2. 리다이렉팅 ( /: 컨텍스트루트 전에 서버 루트(도메인) 기준 절대 경로를 의미)
		response.sendRedirect("https://edu.ssafy.com");
		//response.sendRedirect("/12_result.jsp");
		//response.sendRedirect(request.getContextPath()+"12_result.jsp");

	}

}
