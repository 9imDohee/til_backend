package com.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Filter2 extends HttpFilter implements Filter {
       
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 이 부분에 코드를 작성하면 전처리
		System.out.println("filter 2 request");
		chain.doFilter(request, response);
		// 이 부분에 코드를 작성하면 후처리
		System.out.println("filter 2 response");

	}



}
