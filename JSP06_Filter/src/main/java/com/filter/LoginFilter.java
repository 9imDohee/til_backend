package com.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/board")
public class LoginFilter extends HttpFilter implements Filter {
       
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 로그인한 사람만 볼 수 있음
		// 세션에 loginUser 속성이 있는지 체크
		HttpServletRequest req = (HttpServletRequest) request; // 명시적 형 변환
		HttpServletResponse resp = (HttpServletResponse) response; 
		HttpSession session = req.getSession();
		
		if(session.getAttribute("loginUser")!=null) {
			chain.doFilter(request, response);			
		}else {
			resp.sendRedirect("/login.jsp");
		}
	}
}