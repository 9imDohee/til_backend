package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
 
    public MainServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String act = request.getParameter("act");
    	
    	switch(act) {
    	
    	case "login":
    		doLogin(request,response);
    		
    		break;
    	}
    }

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// id, pw를 통해 유저인지 체크
		if(id!=null && pw!= null) {
			// 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", id);
			
			response.sendRedirect("index.html");
		}else {
			// 로그인 실패
			// 1. 메인으로
			response.sendRedirect("/login.jsp");
			// 2. 로그인 페이지 다시 보여주기
		}
	}


}
