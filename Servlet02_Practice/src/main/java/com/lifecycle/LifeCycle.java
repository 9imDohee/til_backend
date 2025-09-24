package com.lifecycle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Life")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 멤버 필드
	int initCount =1;
	int doGetCount = 1;
	int destroyCount = 1;

	public LifeCycle() {
		System.out.println("기본 생성자 호출");
	}
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출"+ (initCount++));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget 메서드 호출"+(doGetCount++));
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출"+ (destroyCount ++));
	}
}
